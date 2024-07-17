package com.rsc.loggingmanagerclient.dtos;

import java.util.Date;

public class TokenDto {
    private String key;
    private Date expiresAt;

    public TokenDto() {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }
}
