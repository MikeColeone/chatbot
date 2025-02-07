package org.hdx.zsxq.mode.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求问答接口结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerRes {
    private boolean succeeded;
}
