package com.monitoring.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {
    private String access_token;
    private String refresh_token;
    private String token_type;
    private int expires_in;
    private int refresh_expires_in;
    private String scope;
    private String id_token;
    private String session_state;

    @JsonProperty("not-before-policy")
    private String not_before_policy;

}
