package org.hdx.ai;

import java.io.IOException;

public interface IOpenAI {
    String doChatGPT(String openAiKey, String question) throws IOException;

}
