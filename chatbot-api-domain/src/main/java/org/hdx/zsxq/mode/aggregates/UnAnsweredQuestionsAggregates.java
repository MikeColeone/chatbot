package org.hdx.zsxq.mode.aggregates;

import org.hdx.zsxq.mode.res.RespData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;
    private RespData resp_data;

}
