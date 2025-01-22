package org.hdx.ai.mode.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lixing
 * @version V1.0
 * @ClassName:选择
 * @Description:
 * @Date 2024/1/21 22:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Choices{
        private String text;

        private int index;

        private String logprobs;

        private String finish_reason;

}
