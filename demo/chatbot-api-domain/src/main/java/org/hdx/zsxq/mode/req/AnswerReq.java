package org.hdx.zsxq.mode.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求问答接口信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerReq {
    private ReqData req_data;
}
