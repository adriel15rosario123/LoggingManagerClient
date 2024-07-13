package com.rsc.loggingmanagerclient.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SystemEnrollModel {
    private IntegerProperty enrolledSystemId;
    private StringProperty systemName;
    private StringProperty enrolledDate;
    private StringProperty lastUpdatedDate;
    private IntegerProperty errorLogs;
    private IntegerProperty trackingLogs;

    public SystemEnrollModel(int enrolledSystemId, String systemName, String enrolledDate, String lastUpdatedDate, int errorLogs, int trackingLogs) {
        this.enrolledSystemId = new SimpleIntegerProperty(enrolledSystemId);
        this.systemName = new SimpleStringProperty(systemName);
        this.enrolledDate = new SimpleStringProperty(enrolledDate);
        this.lastUpdatedDate = new SimpleStringProperty(lastUpdatedDate);
        this.errorLogs = new SimpleIntegerProperty(errorLogs);
        this.trackingLogs = new SimpleIntegerProperty(trackingLogs);
    }

    public int getEnrolledSystemId() {
        return enrolledSystemId.get();
    }

    public IntegerProperty enrolledSystemIdProperty() {
        return enrolledSystemId;
    }

    public void setEnrolledSystemId(int enrolledSystemId) {
        this.enrolledSystemId.set(enrolledSystemId);
    }

    public String getSystemName() {
        return systemName.get();
    }

    public StringProperty systemNameProperty() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName.set(systemName);
    }

    public String getEnrolledDate() {
        return enrolledDate.get();
    }

    public StringProperty enrolledDateProperty() {
        return enrolledDate;
    }

    public void setEnrolledDate(String enrolledDate) {
        this.enrolledDate.set(enrolledDate);
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate.get();
    }

    public StringProperty lastUpdatedDateProperty() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate.set(lastUpdatedDate);
    }

    public int getErrorLogs() {
        return errorLogs.get();
    }

    public IntegerProperty errorLogsProperty() {
        return errorLogs;
    }

    public void setErrorLogs(int errorLogs) {
        this.errorLogs.set(errorLogs);
    }

    public int getTrackingLogs() {
        return trackingLogs.get();
    }

    public IntegerProperty trackingLogsProperty() {
        return trackingLogs;
    }

    public void setTrackingLogs(int trackingLogs) {
        this.trackingLogs.set(trackingLogs);
    }
}
