package org.hdx.job;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hdx.ai.IOpenAI;
import org.hdx.zsxq.IZsxqApi;
import org.hdx.zsxq.mode.aggregates.UnAnsweredQuestionsAggregates;
import org.hdx.zsxq.mode.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;


@AllArgsConstructor
@NoArgsConstructor
@Component
public class ChatbotTask implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(ChatbotTask.class);

    private String groupName;
    @Value("${chatbot-api.group01.groupId}")
    private String groupId;

    @Value("${chatbot-api.group01.cookie}")
    private String cookie;

    @Resource
    private String openAiKey;

    @Resource
    private boolean silenced;

    @Resource
    private IZsxqApi zsxqApi;

    @Resource
    private IOpenAI openAI;

    @Override
    @Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        try {

            //特别规律的回答有风控风险
            if (new Random().nextBoolean()) {
                logger.info("{} 随机打烊中...", groupName);
                return;
            }

            GregorianCalendar calendar = new GregorianCalendar();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour > 22 || hour < 7) {
                logger.info("{} 打烊时间不工作，AI 下班了！", groupName);
                return;
            }

            // 1. 检索问题
            UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = zsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
            logger.info("{} 检索结果：{}", groupName, JSON.toJSONString(unAnsweredQuestionsAggregates));
            List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
            if (null == topics || topics.isEmpty()) {
                logger.info("{} 本次检索未查询到待会答问题", groupName);
                return;
            }

            // 2. AI 回答
            Topics topic = topics.get(topics.size() - 1);
            String answer = openAI.doChatGPT(openAiKey, topic.getQuestion().getText().trim());
            // 3. 问题回复
            boolean status = zsxqApi.answer(groupId, cookie, topic.getTopic_id(), answer, silenced);
            logger.info("{} 编号：{} 问题：{} 回答：{} 状态：{}", groupName, topic.getTopic_id(), topic.getQuestion().getText(), answer, status);
        } catch (Exception e) {
            logger.error("{} 自动回答问题异常", groupName, e);
        }
    }

}

