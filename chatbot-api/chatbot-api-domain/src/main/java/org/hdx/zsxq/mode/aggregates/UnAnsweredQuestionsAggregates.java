package org.hdx.zsxq.mode.aggregates;

import org.hdx.zsxq.mode.res.RespData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lixing
 * @version V1.0
 * @ClassName:未回答问题的聚合信息
 * @Description:
 * @Date 2024/1/21 22:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnAnsweredQuestionsAggregates {
    private boolean succeeded;
    private RespData resp_data;

}
