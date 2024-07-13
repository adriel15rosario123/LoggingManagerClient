package com.rsc.loggingmanagerclient.dtos;

public class UserDto {

    private int userId;
    private String username;
    private UserTypeDto userTypeDto;

    public UserDto(int userId, String username, UserTypeDto userTypeDto) {
        this.userId = userId;
        this.username = username;
        this.userTypeDto = userTypeDto;
    }

    public UserDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
