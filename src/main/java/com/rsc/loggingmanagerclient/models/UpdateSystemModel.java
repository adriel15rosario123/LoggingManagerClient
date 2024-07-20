package com.rsc.loggingmanagerclient.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UpdateSystemModel {

    private IntegerProperty systemId;
    private StringProperty username;
    private StringProperty password;
    private StringProperty systemName;
    private StringProperty errorMessage;

    public UpdateSystemModel(int systemId, String username, String password, String systemName) {
        this.systemId = new SimpleIntegerProperty(systemId);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.systemName = new SimpleStringProperty(systemName);
        this.errorMessage = new SimpleStringProperty();
    }

    public UpdateSystemModel() {
        this.systemId = new SimpleIntegerProperty();
        this.username = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.systemName = new SimpleStringProperty();
        this.errorMessage = new SimpleStringProperty();
    }

    public String getErrorMessage() {
        return errorMessage.get();
    }

    public StringProperty errorMessageProperty() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage.set(errorMessage);
    }

    public int getSystemId() {
        return systemId.get();
    }

    public IntegerProperty systemIdProperty() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId.set(systemId);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
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

    public void cleanValues(){
        setUsername("");
        setPassword("");
        setSystemName("");
    }
}
