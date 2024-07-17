package com.rsc.loggingmanagerclient.commands;

import com.rsc.loggingmanagerclient.dtos.CredentialDto;
import com.rsc.loggingmanagerclient.dtos.UserDto;
import com.rsc.loggingmanagerclient.enums.Views;
import com.rsc.loggingmanagerclient.exceptions.IncorrectCredentialException;
import com.rsc.loggingmanagerclient.models.LoginModel;
import javafx.concurrent.Task;

public class LoginCommand extends BaseCommand<UserDto> {

    private LoginModel loginModel;

    public LoginCommand(LoginModel loginModel) {
        this.loginModel = loginModel;

        setOnCommandSuccess(this::onSuccess);
        setOnCommandFailure(this::onFailure);
    }

    @Override
    protected Task<UserDto> createCommandTask() {
        return new Task<>() {
            @Override
            protected UserDto call() throws Exception {
                String currentUsername = loginModel.getUsername();
                String currentPassword = loginModel.getPassword();

                // Simulate a long-running operation
                for (int i = 0; i <= 100; i++) {
                    updateProgress(i, 100);
                    updateMessage("Progress: " + i + "%");
                    Thread.sleep(10);
                }

                return getServices().getAuthService().login(new CredentialDto(currentUsername, currentPassword));
            }
        };
    }

    private void onSuccess() {
        getViewHandler().openView(Views.HOME);
    }

    private void onFailure() {

        if(getCommandTask().getException() instanceof IncorrectCredentialException){
            this.loginModel.setBadCredentials(getCommandTask().getException().getMessage());
        }else{
            getCommandTask().getException().printStackTrace();
            getViewHandler().openModal(Views.SERVER_OFF_MODAL);
        }
    }
}