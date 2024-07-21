package com.rsc.loggingmanagerclient.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ErrorLogModel extends LogModel {

//    private static StringProperty numOfErrors = new SimpleStringProperty();
    private static StringProperty systemName = new SimpleStringProperty();
    private StringProperty message;

    public ErrorLogModel(int logId, String loggingDate, String methodName, String methodInput, String methodOutput, String logType, String message) {
        super(logId, loggingDate, methodName, methodInput, methodOutput, logType);
        this.message = new SimpleStringProperty(message);
    }

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }

    public void setMessage(String message) {
        this.message.set(message);
    }

//    public static String getNumOfErrors() {
//        return numOfErrors.get();
//    }
//
//    public static StringProperty numOfErrorsProperty() {
//        return numOfErrors;
//    }
//
//    public static void setNumOfErrors(int numOfErrors) {
//        ErrorLogModel.numOfErrors.set(String.valueOf(numOfErrors));
//    }

    public static String getSystemName() {
        return systemName.get();
    }

    public static StringProperty systemNameProperty() {
        return systemName;
    }

    public static void setSystemName(String systemName) {
        ErrorLogModel.systemName.set(systemName);
    }
}
