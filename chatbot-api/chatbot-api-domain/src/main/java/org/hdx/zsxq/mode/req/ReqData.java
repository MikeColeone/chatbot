package org.hdx.zsxq.mode.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqData {
    private String text;
    private String[] mentioned_user_ids;
    private boolean silenced;

    public ReqData(String text, boolean silenced) {
        this.text = text;
        this.silenced = silenced;
    }
}

//    String paramJson = "{\n" +
//            "  \"req_data\": {\n" +
//            "    \"text\": \"哈哈，写脚本推上去了\\n\",\n" +
//            "    \"mentioned_user_ids\": [],\n" +
//            "    \"silenced\": false\n" +
//            "  }\n" +
//            "}";