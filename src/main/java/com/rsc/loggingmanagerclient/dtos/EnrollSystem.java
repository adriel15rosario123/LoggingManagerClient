package com.rsc.loggingmanagerclient.dtos;

import java.util.Date;

public class EnrollSystem {

    private int enrolledSystemId;
    private String systemName;
    private Date enrolledDate;
    private Date lastUpdatedDate;
    private int errorLogs;
    private int trackingLogs;

    public EnrollSystem() {
    }

    public int getEnrolledSystemId() {
        return enrolledSystemId;
    }

    public void setEnrolledSystemId(int enrolledSystemId) {
        this.enrolledSystemId = enrolledSystemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public Date getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(Date enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public int getErrorLogs() {
        return errorLogs;
    }

    public void setErrorLogs(int errorLogs) {
        this.errorLogs = errorLogs;
    }

    public int getTrackingLogs() {
        return trackingLogs;
    }

    public void setTrackingLogs(int trackingLogs) {
        this.trackingLogs = trackingLogs;
    }
}
