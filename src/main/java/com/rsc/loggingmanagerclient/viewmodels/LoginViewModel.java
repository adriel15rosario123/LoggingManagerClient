package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.contracts.IAuthService;
import com.rsc.loggingmanagerclient.dtos.UserDto;
import com.rsc.loggingmanagerclient.enums.ViewEnum;
import com.rsc.loggingmanagerclient.dtos.CredentialDto;
import com.rsc.loggingmanagerclient.models.LoginModel;
import javafx.beans.property.*;
import javafx.concurrent.Task;

public class LoginViewModel extends BaseViewModel {

    private LoginModel loginModel;
    private IAuthService authService;

    public LoginViewModel(IAuthService userService){
        this.authService = userService;
        this.loginModel = new LoginModel();
    }

    public LoginModel loginModel() {
        return this.loginModel;
    }

    public void LogIn(){
        Task<UserDto> login = new Task<>() {
            @Override
            protected UserDto call() throws Exception {

                String currentUsername = loginModel.getUsername();
                String currentPassword = loginModel.getPassword();

                // Simulate a long-running operation
                for (int i = 0; i <= 100; i++) {
                    // Update the progress
                    updateProgress(i, 100);
                    // Update the message
                    updateMessage("Progress: " + i + "%");
                    // Simulate work
                    Thread.sleep(10);
                }

                UserDto userDto = authService.login(new CredentialDto(currentUsername,currentPassword));

                return userDto;
            }
        };

        executeTask(login,() -> {

            if(login.getValue() == null){
                loginModel.setBadCredentials("invalid username/password!!");
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


}
