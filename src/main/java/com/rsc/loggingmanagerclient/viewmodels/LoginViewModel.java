package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.commands.LoginCommand;
import com.rsc.loggingmanagerclient.models.LoginModel;

public class LoginViewModel extends BaseViewModel {

    private LoginModel loginModel;

    public LoginViewModel(){
        this.loginModel = new LoginModel();
    }

    public LoginModel loginModel() {
        return this.loginModel;
    }

    public void LogIn(){
        LoginCommand command = new LoginCommand(this.loginModel);
        command.execute();
    }

}
