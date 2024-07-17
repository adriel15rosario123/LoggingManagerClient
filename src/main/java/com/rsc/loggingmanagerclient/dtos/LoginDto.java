package com.rsc.loggingmanagerclient.dtos;
public class LoginDto {

    private UserDto user;
    private TokenDto token;

    public LoginDto() {
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public TokenDto getToken() {
        return token;
    }

    public void setToken(TokenDto token) {
        this.token = token;
    }
}
