package com.rsc.loggingmanagerclient.models;

public class UserType {

    private int userTypeId;
    private String type;

    public UserType(int userTypeId, String type) {
        this.userTypeId = userTypeId;
        this.type = type;
    }

    public UserType() {
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
