package com.rsc.loggingmanagerclient.dtos;

import com.rsc.loggingmanagerclient.models.User;

import java.util.Date;

public class LoginResponse{

    private String accessToken;
    private Date expires;
    private ApiResponse<User> response;

    public LoginResponse(String accessToken, Date expiresAt, ApiResponse<User> response) {
        this.accessToken = accessToken;
        this.expires = expiresAt;
        this.response = response;
    }

    public LoginResponse() {

    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expiresAt) {
        this.expires = expiresAt;
    }

    public ApiResponse<User> getResponse() {
        return response;
    }

    public void setResponse(ApiResponse<User> response) {
        this.response = response;
    }
}
