package com.rsc.loggingmanagerclient.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginModel {
    private StringProperty username;
    private StringProperty password;
    private StringProperty badCredentials;

    public LoginModel() {
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.badCredentials = new SimpleStringProperty("");
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

    public String getBadCredentials() {
        return badCredentials.get();
    }

    public StringProperty badCredentialsProperty() {
        return badCredentials;
    }

    public void setBadCredentials(String badCredentials) {
        this.badCredentials.set(badCredentials);
    }
}
