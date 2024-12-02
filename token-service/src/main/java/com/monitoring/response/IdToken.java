package com.monitoring.response;

import lombok.Data;

@Data
public class IdToken {
        private long exp;
        private long iat;
        private long auth_time;
        private String jti;
        private String iss;
        private String aud;
        private String sub;
        private String typ;
        private String azp;
        private String session_state;
        private String at_hash;
        private String acr;
        private String sid;
        private boolean email_verified;
        private String name;
        private String preferred_username;
        private String given_name;
        private String family_name;
        private String email;
    }
