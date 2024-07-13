package com.rsc.loggingmanagerclient.views;

import com.rsc.loggingmanagerclient.viewmodels.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML
    private Label errorMessageLb;

    @FXML
    private Button loginBt;

    @FXML
    private PasswordField passwordPf;

    @FXML
    private TextField usernameTf;

    private LoginViewModel viewModel;

    public LoginController(){

    }

    public void init(LoginViewModel viewModel){
        this.viewModel = viewModel;
        this.errorMessageLb.textProperty().bindBidirectional(this.viewModel.loginModel().badCredentialsProperty());
        this.usernameTf.textProperty().bindBidirectional(this.viewModel.loginModel().usernameProperty());
        this.passwordPf.textProperty().bindBidirectional(this.viewModel.loginModel().passwordProperty());
        this.loginBt.disableProperty().bindBidirectional(this.viewModel.isRunningProperty());
    }

    public void onLoginClick(){
        this.viewModel.LogIn();
    }


}
