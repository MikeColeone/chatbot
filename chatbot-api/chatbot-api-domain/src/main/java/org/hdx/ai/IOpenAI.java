package org.hdx.ai;

import java.io.IOException;

/**
 * @author lixing
 * @version V1.0
 * @ClassName:ChatGPT open ai 接口：https://beta.openai.com/account/api-keys
 * @Description:
 * @Date 2024/1/21 22:54
 */
public interface IOpenAI {
    String doChatGPT(String openAiKey, String question) throws IOException;

}
