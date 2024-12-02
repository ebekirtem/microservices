package com.monitoring.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class AccessTokenPayload {

    private long exp;
    private long iat;
    private long authTime;
    private String jti;
    private String iss;
    private String aud;
    private String sub;
    private String typ;
    private String azp;
    private String sessionState;
    private String acr;
    private List<String> allowedOrigins;
    private RealmAccess realmAccess;
    private ResourceAccess resourceAccess;
    private String scope;
    private String sid;
    private boolean emailVerified;
    private String name;
    private String preferredUsername;
    private String givenName;
    private String familyName;
    private String email;

    // Getter ve Setter methodları

    public static class RealmAccess {
        private List<String> roles;

        // Getter ve Setter methodları
    }

    public static class ResourceAccess {
        private Map<String, Account> account;

        // Getter ve Setter methodları
    }

    public static class Account {
        private List<String> roles;

        // Getter ve Setter methodları
    }

    @JsonProperty("exp")
    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    @JsonProperty("iat")
    public long getIat() {
        return iat;
    }

    public void setIat(long iat) {
        this.iat = iat;
    }

    @JsonProperty("auth_time")
    public long getAuthTime() {
        return authTime;
    }

    public void setAuthTime(long authTime) {
        this.authTime = authTime;
    }

    @JsonProperty("jti")
    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    @JsonProperty("iss")
    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }

    @JsonProperty("aud")
    public String getAud() {
        return aud;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    @JsonProperty("sub")
    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    @JsonProperty("typ")
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    @JsonProperty("azp")
    public String getAzp() {
        return azp;
    }

    public void setAzp(String azp) {
        this.azp = azp;
    }

    @JsonProperty("session_state")
    public String getSessionState() {
        return sessionState;
    }

    public void setSessionState(String sessionState) {
        this.sessionState = sessionState;
    }

    @JsonProperty("acr")
    public String getAcr() {
        return acr;
    }

    public void setAcr(String acr) {
        this.acr = acr;
    }

    @JsonProperty("allowed-origins")
    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    @JsonProperty("realm_access")
    public RealmAccess getRealmAccess() {
        return realmAccess;
    }

    public void setRealmAccess(RealmAccess realmAccess) {
        this.realmAccess = realmAccess;
    }

    @JsonProperty("resource_access")
    public ResourceAccess getResourceAccess() {
        return resourceAccess;
    }

    public void setResourceAccess(ResourceAccess resourceAccess) {
        this.resourceAccess = resourceAccess;
    }

    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonProperty("sid")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @JsonProperty("email_verified")
    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("preferred_username")
    public String getPreferredUsername() {
        return preferredUsername;
    }

    public void setPreferredUsername(String preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    @JsonProperty("given_name")
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    @JsonProperty("family_name")
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
