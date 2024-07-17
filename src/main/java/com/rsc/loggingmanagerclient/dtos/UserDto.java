package com.rsc.loggingmanagerclient.dtos;

public class UserDto {

    private Integer userId;
    private String username;
    private UserTypeDto userTypeDto;

    public UserDto(Integer userId, String username, UserTypeDto userTypeDto) {
        this.userId = userId;
        this.username = username;
        this.userTypeDto = userTypeDto;
    }

    public UserDto() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserTypeDto getUserTypeDto() {
        return userTypeDto;
    }

    public void setUserTypeDto(UserTypeDto userTypeDto) {
        this.userTypeDto = userTypeDto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserTypeDto getUserType() {
        return userTypeDto;
    }

    public void setUserType(UserTypeDto userTypeDto) {
        this.userTypeDto = userTypeDto;
    }
}
