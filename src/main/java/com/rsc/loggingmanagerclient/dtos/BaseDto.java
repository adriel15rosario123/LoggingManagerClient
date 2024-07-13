package com.rsc.loggingmanagerclient.dtos;

public class BaseDto<T> {

    private T responseData;
    private int errorCode;
    private String errorMessage;

    public BaseDto(T responseData, int errorCode, String errorMessage) {
        this.responseData = responseData;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseDto(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseDto(){

    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
