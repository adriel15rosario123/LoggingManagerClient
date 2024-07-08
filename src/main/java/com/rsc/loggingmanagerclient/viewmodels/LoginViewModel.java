package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.contracts.IAuthService;
import com.rsc.loggingmanagerclient.enums.ViewEnum;
import com.rsc.loggingmanagerclient.models.Credential;
import com.rsc.loggingmanagerclient.models.User;
import javafx.beans.property.*;
import javafx.concurrent.Task;

public class LoginViewModel extends BaseViewModel {

    private StringProperty username;
    private StringProperty password;
    private StringProperty badCredentials;
    private IAuthService authService;

    public LoginViewModel(IAuthService userService){
        this.authService = userService;
        this.username = new SimpleStringProperty("");
        this.password = new SimpleStringProperty("");
        this.badCredentials = new SimpleStringProperty("");
    }

    public void LogIn(){
        Task<User> login = new Task<>() {
            @Override
            protected User call() throws Exception {

                String currentUsername = username.get();
                String currentPassword = password.get();

                // Simulate a long-running operation
                for (int i = 0; i <= 100; i++) {
                    // Update the progress
                    updateProgress(i, 100);
                    // Update the message
                    updateMessage("Progress: " + i + "%");
                    // Simulate work
                    Thread.sleep(10);
                }

                User user = authService.login(new Credential(currentUsername,currentPassword));

                return user;
            }
        };

        executeTask(login,() -> {

            if(login.getValue() == null){
                badCredentials.set("invalid username/password!!");
            } else if (login.getValue().getUserType().getType().equals("admin")) {
                try {
                    viewHandler.openView(ViewEnum.HOME);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        },() -> {
            System.out.println(login.getException().getMessage());
        });

    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public StringProperty badCredentialsProperty() {
        return badCredentials;
    }

}
