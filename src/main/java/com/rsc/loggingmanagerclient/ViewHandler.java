package com.rsc.loggingmanagerclient;

import com.rsc.loggingmanagerclient.enums.Views;
import com.rsc.loggingmanagerclient.factories.ViewModelFactory;
import com.rsc.loggingmanagerclient.helpers.TokenHandler;
import com.rsc.loggingmanagerclient.views.HomeController;
import com.rsc.loggingmanagerclient.views.LoginController;
import com.rsc.loggingmanagerclient.views.LogoutController;
import com.rsc.loggingmanagerclient.views.ServerOffController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private static ViewHandler viewHandler;
    private Stage stage;
    private Stage dialog;
    private ViewModelFactory viewModelFactory;

    private ViewHandler(Stage stage, ViewModelFactory viewModelFactory){
        this.stage = stage;
        this.viewModelFactory = viewModelFactory;
    }

    public static ViewHandler getViewHandlerInstance(Stage stage,ViewModelFactory viewModelFactory){
        if(viewHandler == null && stage != null && viewModelFactory != null){
            viewHandler = new ViewHandler(stage,viewModelFactory);
        }
        return viewHandler;
    }

    public static ViewHandler getViewHandlerInstance(){
        return viewHandler;
    }

    public void start() throws Exception{

        //add the defaults pref (username, password, userId, userRole, authToke)
        TokenHandler.savePref("userId", TokenHandler.getPref("userId"));
        TokenHandler.savePref("jwt",  TokenHandler.getPref("jwt"));

        System.out.println("currentUserId: "+TokenHandler.getPref("userId"));
        System.out.println("currentjwt: "+TokenHandler.getPref("jwt"));

        //check if the token is valid and if it's valid open the home view directly
        if(TokenHandler.isTokenValid()){
            openView(Views.HOME);
        }else{
            openView(Views.LOGIN);
        }
    }

    public void openView(Views viewToOpen) {
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(LoggingManagerApp.class.getResource(viewToOpen.toString()));

        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        switch (viewToOpen){
            case LOGIN -> {
                LoginController view = loader.getController();
                view.init(viewModelFactory.getLoginViewModel());
                stage.setResizable(false);
                stage.setTitle("Log In");
            }
            case HOME -> {
                HomeController view = loader.getController();
                view.init(viewModelFactory.getHomeViewModel());
                stage.setResizable(false);
                stage.setTitle("Home");
            }
        }

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openModal(Views modalToOpen){
        dialog = new Stage();
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(LoggingManagerApp.class.getResource(modalToOpen.toString()));

        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        switch (modalToOpen){
            case LOGOUT_MODAL -> {
                LogoutController modal = loader.getController();
                modal.init(viewModelFactory.getLogoutViewModel());
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(this.stage);
                dialog.setTitle("Logout");
                dialog.setResizable(false);
            }
            case SERVER_OFF_MODAL -> {
                ServerOffController modal = loader.getController();
                //modal.init(viewModelFactory.getLogoutViewModel());
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(this.stage);
                dialog.setTitle("Server Off");
                dialog.setResizable(false);
            }
        }

        scene = new Scene(root);
        dialog.setScene(scene);
        dialog.showAndWait();
    }

    public void closeModal(){
        if(dialog != null){
            dialog.close();
        }
    }

}
