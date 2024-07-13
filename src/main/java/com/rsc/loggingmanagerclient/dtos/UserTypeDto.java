package com.rsc.loggingmanagerclient.dtos;

public class UserTypeDto {

    private int userTypeId;
    private String type;

    public UserTypeDto(int userTypeId, String type) {
        this.userTypeId = userTypeId;
        this.type = type;
    }

    public UserTypeDto() {
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
