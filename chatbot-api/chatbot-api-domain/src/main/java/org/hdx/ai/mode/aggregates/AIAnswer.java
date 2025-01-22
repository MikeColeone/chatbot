package org.hdx.ai.mode.aggregates;

import org.hdx.ai.mode.vo.Choices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AIAnswer {


    private String id;

    private String object;

    private int created;

    private String model;

    private List<Choices> choices;


}
