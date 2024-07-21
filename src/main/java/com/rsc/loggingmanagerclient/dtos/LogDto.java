package com.rsc.loggingmanagerclient.dtos;

public class LogDto {

    private int logId;
    private String loggingDate;
    private String methodName;
    private String methodInput;
    private String methodOutput;
    private String logType;

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getLoggingDate() {
        return loggingDate;
    }

    public void setLoggingDate(String loggingDate) {
        this.loggingDate = loggingDate;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodInput() {
        return methodInput;
    }

    public void setMethodInput(String methodInput) {
        this.methodInput = methodInput;
    }

    public String getMethodOutput() {
        return methodOutput;
    }

    public void setMethodOutput(String methodOutput) {
        this.methodOutput = methodOutput;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }
}
