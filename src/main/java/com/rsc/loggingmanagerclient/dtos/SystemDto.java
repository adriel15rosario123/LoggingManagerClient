package com.rsc.loggingmanagerclient.dtos;

import java.util.Date;

public class SystemDto {

    private int systemId;
    private String systemUsername;
    private String systemPassword;
    private String systemName;
    private Date enrolledDate;
    private Date lastUpdatedDate;
    private int errorLogs;
    private int trackingLogs;

    public SystemDto() {
    }

    public String getSystemUsername() {
        return systemUsername;
    }

    public void setSystemUsername(String systemUsername) {
        this.systemUsername = systemUsername;
    }

    public String getSystemPassword() {
        return systemPassword;
    }

    public void setSystemPassword(String systemPassword) {
        this.systemPassword = systemPassword;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int enrolledSystemId) {
        this.systemId = enrolledSystemId;
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
