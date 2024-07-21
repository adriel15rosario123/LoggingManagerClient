package com.rsc.loggingmanagerclient.dtos;

public class ErrorLogDto extends LogDto {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
