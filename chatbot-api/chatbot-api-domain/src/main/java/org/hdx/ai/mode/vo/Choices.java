package org.hdx.ai.mode.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
