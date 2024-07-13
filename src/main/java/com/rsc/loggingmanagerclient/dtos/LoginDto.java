package com.rsc.loggingmanagerclient.dtos;

import java.util.Date;

public class LoginDto {

    private String accessToken;
    private Date expires;
    private BaseDto<UserDto> response;

    public LoginDto(String accessToken, Date expiresAt, BaseDto<UserDto> response) {
        this.accessToken = accessToken;
        this.expires = expiresAt;
        this.response = response;
    }

    public LoginDto() {

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

    public BaseDto<UserDto> getResponse() {
        return response;
    }

    public void setResponse(BaseDto<UserDto> response) {
        this.response = response;
    }
}
