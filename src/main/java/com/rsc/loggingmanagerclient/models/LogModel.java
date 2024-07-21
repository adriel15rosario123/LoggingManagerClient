package com.rsc.loggingmanagerclient.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LogModel {

    private IntegerProperty logId;
    private StringProperty loggingDate;
    private StringProperty methodName;
    private StringProperty methodInput;
    private StringProperty methodOutput;
    private StringProperty logType;

    public LogModel(int logId, String loggingDate, String methodName, String methodInput, String methodOutput, String logType) {
        this.logId = new SimpleIntegerProperty(logId);
        this.loggingDate = new SimpleStringProperty(loggingDate);
        this.methodName = new SimpleStringProperty(methodName);
        this.methodInput = new SimpleStringProperty(methodInput);
        this.methodOutput = new SimpleStringProperty(methodOutput);
        this.logType = new SimpleStringProperty(logType);
    }

    public int getLogId() {
        return logId.get();
    }

    public IntegerProperty logIdProperty() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId.set(logId);
    }

    public String getLoggingDate() {
        return loggingDate.get();
    }

    public StringProperty loggingDateProperty() {
        return loggingDate;
    }

    public void setLoggingDate(String loggingDate) {
        this.loggingDate.set(loggingDate);
    }

    public String getMethodName() {
        return methodName.get();
    }

    public StringProperty methodNameProperty() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName.set(methodName);
    }

    public String getMethodInput() {
        return methodInput.get();
    }

    public StringProperty methodInputProperty() {
        return methodInput;
    }

    public void setMethodInput(String methodInput) {
        this.methodInput.set(methodInput);
    }

    public String getMethodOutput() {
        return methodOutput.get();
    }

    public StringProperty methodOutputProperty() {
        return methodOutput;
    }

    public void setMethodOutput(String methodOutput) {
        this.methodOutput.set(methodOutput);
    }

    public String getLogType() {
        return logType.get();
    }

    public StringProperty logTypeProperty() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType.set(logType);
    }
}
