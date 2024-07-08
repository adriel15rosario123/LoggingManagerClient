package com.rsc.loggingmanagerclient.models;

public class User {

    private int userId;
    private String username;
    private UserType userType;

    public User(int userId, String username, UserType userType) {
        this.userId = userId;
        this.username = username;
        this.userType = userType;
    }

    public User() {
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
