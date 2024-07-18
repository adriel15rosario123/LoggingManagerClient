package com.rsc.loggingmanagerclient.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreateSystemModel {
    private StringProperty username;
    private StringProperty password;
    private StringProperty systemName;
    private StringProperty errorMessage;

    public CreateSystemModel() {
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        systemName = new SimpleStringProperty();
        errorMessage = new SimpleStringProperty();
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
