package com.rsc.loggingmanagerclient.views;

import com.rsc.loggingmanagerclient.viewmodels.EnrollSystemViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EnrollSystemController {

    @FXML
    private Label errorMessageLb;

    @FXML
    private TextField passwordTf;

    @FXML
    private TextField systemNameTf;

    @FXML
    private TextField usernameTf;

    private EnrollSystemViewModel enrollSystemViewModel;

    public void init(EnrollSystemViewModel enrollSystemViewModel){
        this.enrollSystemViewModel = enrollSystemViewModel;

        this.errorMessageLb.textProperty().bindBidirectional(this.enrollSystemViewModel.getCreateSystemModel().errorMessageProperty());
        this.passwordTf.textProperty().bindBidirectional(this.enrollSystemViewModel.getCreateSystemModel().passwordProperty());
        this.systemNameTf.textProperty().bindBidirectional(this.enrollSystemViewModel.getCreateSystemModel().systemNameProperty());
        this.usernameTf.textProperty().bindBidirectional(this.enrollSystemViewModel.getCreateSystemModel().usernameProperty());
    }
    public void goToPrevView(){
        this.enrollSystemViewModel.goToPrevView();
    }

    public void onCreateClick(){
        this.enrollSystemViewModel.createNewSystem();
    }
}
