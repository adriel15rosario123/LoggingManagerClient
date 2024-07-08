package com.rsc.loggingmanagerclient.dtos;

public class ApiResponse<T> {

    private T responseData;
    private int errorCode;
    private String errorMessage;

    public ApiResponse(T responseData, int errorCode, String errorMessage) {
        this.responseData = responseData;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ApiResponse(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ApiResponse(){

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
