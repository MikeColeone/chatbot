package org.hdx.zsxq.mode.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Questionee {
    private String user_id;

    private String name;

    private String avatar_url;

    private String description;

    private String location;

}
