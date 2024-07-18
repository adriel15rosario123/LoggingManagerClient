package com.rsc.loggingmanagerclient.dtos;

public class CreateSystemDto {

    private String username;
    private String password;
    private String systemName;

    public CreateSystemDto(String username, String password, String systemName) {
        this.username = username;
        this.password = password;
        this.systemName = systemName;
    }

    public CreateSystemDto() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
}
