import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author lixing
 * @version V1.0
 * @ClassName:
 * @Description:
 * @Date 2024/1/21 22:51
 */
public class ApiTest {

    @Test
    public void base64(){
        String cronExpression = new String(Base64.getDecoder().decode("MC81MCAqICogKiAqID8="), StandardCharsets.UTF_8);
        System.out.println(cronExpression);
    }

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48888125158188/topics?scope=all&count=20");

        get.addHeader("cookie",
                "zsxq_access_token=B7378E4C-6177-EA28-FFA3-49847768420C_88C8C9B07BCB99FD; zsxqsessionid=e0b2e677335f1f5aae9357ddcb84c36e; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415454814188548%22%2C%22first_id%22%3A%2219486e59a83aec-031dc7645cfd1ee-4c657b58-2073600-19486e59a84f1c%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk0ODZlNTlhODNhZWMtMDMxZGM3NjQ1Y2ZkMWVlLTRjNjU3YjU4LTIwNzM2MDAtMTk0ODZlNTlhODRmMWMiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU0NTQ4MTQxODg1NDgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415454814188548%22%7D%7D");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println("查询成功拿到的数据是："+res);
            res = JSONObject.parseObject(res).toJSONString(); //将Unicode转码为中文 使用Fastjson的parseObject方法将JSON转换后再转为字符串
            System.out.println(res);

        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/8858158288185282/comments");
        post.addHeader("cookie", "zsxq_access_token=B7378E4C-6177-EA28-FFA3-49847768420C_88C8C9B07BCB99FD; zsxqsessionid=e0b2e677335f1f5aae9357ddcb84c36e; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22415454814188548%22%2C%22first_id%22%3A%2219486e59a83aec-031dc7645cfd1ee-4c657b58-2073600-19486e59a84f1c%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk0ODZlNTlhODNhZWMtMDMxZGM3NjQ1Y2ZkMWVlLTRjNjU3YjU4LTIwNzM2MDAtMTk0ODZlNTlhODRmMWMiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI0MTU0NTQ4MTQxODg1NDgifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22415454814188548%22%7D%7D");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"哈哈，写脚本推上去了\\n\",\n" +
                "    \"mentioned_user_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
            res = JSONObject.parseObject(res).toJSONString();
            System.out.println("不保留转义的结果是："+res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void test_chatGPT() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // HttpPost post = new HttpPost("https://api.openai.com/v1/chat/completions");
        // HttpPost post = new HttpPost("https://ai.fakeopen.com/api/conversation");
        HttpPost post = new HttpPost("https://api.openai-proxy.com/v1/chat/completions");
        post.addHeader("Content-Type", "application/json");
        // post.addHeader("Authorization", "Bearer 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");
        post.addHeader("Authorization", "Bearer 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");

        String paramJson = "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"写一个Java冒泡排序\"}]}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String jsonStr = EntityUtils.toString(response.getEntity());

            JSONObject jsonObj = JSONArray.parseObject(jsonStr);
            JSONArray choicesArr = jsonObj.getJSONArray("choices");

            // 处理第一个 choice 的 message
            JSONObject choice0 = choicesArr.getJSONObject(0);
            JSONObject messageObj = choice0.getJSONObject("message");
            String role = messageObj.getString("role");
            String content = messageObj.getString("content");

            System.out.println(jsonStr);
            System.out.println("==================================================");
            System.out.println("Role: " + role);
            System.out.println("Content: " + content);

        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }
}
    /*curl https://api.openai-proxy.com/v1/chat/completions \
        -H "Content-Type: application/json" \
        -H "Authorization: Bearer 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" \
        -d '{
        "model": "gpt-3.5-turbo",
        "messages": [{"role": "user", "content": "Hello!"}]
        }'*/