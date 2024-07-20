package com.rsc.loggingmanagerclient.views;

import com.rsc.loggingmanagerclient.viewmodels.EnrollSystemViewModel;
import com.rsc.loggingmanagerclient.viewmodels.UpdateSystemViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpdateSystemController {
    @FXML
    private Label errorMessageLb;

    @FXML
    private TextField passwordTf;

    @FXML
    private TextField systemNameTf;

    @FXML
    private TextField usernameTf;

    private UpdateSystemViewModel updateSystemViewModel;

    public void init(UpdateSystemViewModel updateSystemViewModel){
        this.updateSystemViewModel = updateSystemViewModel;

        this.errorMessageLb.textProperty().bindBidirectional(this.updateSystemViewModel.getUpdateSystemModel().errorMessageProperty());
        this.passwordTf.textProperty().bindBidirectional(this.updateSystemViewModel.getUpdateSystemModel().passwordProperty());
        this.systemNameTf.textProperty().bindBidirectional(this.updateSystemViewModel.getUpdateSystemModel().systemNameProperty());
        this.usernameTf.textProperty().bindBidirectional(this.updateSystemViewModel.getUpdateSystemModel().usernameProperty());

    }

    public void goToPrevView(){
        this.updateSystemViewModel.goToPrevView();
    }

    public void onUpdateClick(){
        this.updateSystemViewModel.updateSystem();
    }
}
