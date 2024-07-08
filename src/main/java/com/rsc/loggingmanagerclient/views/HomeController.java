package com.rsc.loggingmanagerclient.views;

import com.rsc.loggingmanagerclient.viewmodels.HomeViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Button logoutBt;

    private HomeViewModel homeViewModel;

    public HomeController() {
    }

    public void init(HomeViewModel homeViewModel){
        this.homeViewModel = homeViewModel;
    }

    public void onLogoutClick(){
        this.homeViewModel.logout();
    }

}
