import org.hdx.ApiApplication;
import org.hdx.zsxq.IZsxqApi;
import org.hdx.zsxq.mode.aggregates.UnAnsweredQuestionsAggregates;
import org.hdx.zsxq.mode.vo.Topics;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class RunTest {
    private Logger logger = LoggerFactory.getLogger(RunTest.class);


    @Value("${chatbot-api.group01.groupId}")
    private String groupId;

    @Value("${chatbot-api.group01.cookie}")
    private String cookie;

//    @Value("${chatbot-api.group01.openAiKey}")
//    private String openAiKey;


    @Resource
    private IZsxqApi iZsxqApi;
//    @Resource
//    private IOpenAI openAI;

    @Test
    public void test_zsxqApi() throws IOException {
        UnAnsweredQuestionsAggregates unAnsweredQuestionsAggregates = iZsxqApi.queryUnAnsweredQuestionsTopicId(groupId, cookie);
        logger.info("测试结果：{}", JSON.toJSONString(unAnsweredQuestionsAggregates));

        List<Topics> topics = unAnsweredQuestionsAggregates.getResp_data().getTopics();
        for (Topics topic : topics) {
            String topicId = topic.getTopic_id();
            String text = topic.getQuestion().getText();

            //回答问题
            //iZsxqApi.answer(groupId,cookie,topicId,text,false);
        }
    }

//    @Test
//    public void test_openAi() throws IOException {
//        String response = openAI.doChatGPT(openAiKey, "帮我写一个java冒泡排序");
//        logger.info("测试结果：{}", response);
//    }

}
