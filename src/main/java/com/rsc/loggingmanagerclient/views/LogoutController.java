package com.rsc.loggingmanagerclient.views;

import com.rsc.loggingmanagerclient.viewmodels.LogoutViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LogoutController {

    @FXML
    private Button cancelBt;

    @FXML
    private Button signOutBt;

    private LogoutViewModel logoutViewModel;

    public LogoutController() {
    }

    public void init(LogoutViewModel logoutViewModel){
        this.logoutViewModel = logoutViewModel;
    }

    public void onCancelBtClick(){
        this.logoutViewModel.cancel();
    }

    public void onSignoutBtClick(){
        this.logoutViewModel.signOut();
    }
}
