package org.hdx.zsxq.mode.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSpecific {
    private boolean liked;

    private boolean subscribed;

}
