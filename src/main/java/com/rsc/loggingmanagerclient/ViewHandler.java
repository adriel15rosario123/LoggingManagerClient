package com.rsc.loggingmanagerclient;

import com.rsc.loggingmanagerclient.enums.Views;
import com.rsc.loggingmanagerclient.factories.ViewModelFactory;
import com.rsc.loggingmanagerclient.helpers.TokenHandler;
import com.rsc.loggingmanagerclient.models.UpdateSystemModel;
import com.rsc.loggingmanagerclient.viewmodels.UpdateSystemViewModel;
import com.rsc.loggingmanagerclient.views.*;
import com.rsc.loggingmanagerclient.views.modals.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Stack;

public class ViewHandler {

    private static Stack<Views> visitViews = new Stack<>();
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
                visitViews.push(Views.HOME);
            }
            case ENROLL_SYSTEM -> {
                EnrollSystemController view = loader.getController();
                view.init(viewModelFactory.getEnrollSystemViewModel());
                stage.setResizable(false);
                stage.setTitle("Enroll System");
                visitViews.push(Views.ENROLL_SYSTEM);
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
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(this.stage);
                dialog.setTitle("Server Off");
                dialog.setResizable(false);
            }
            case SUCCESSFULLY_CREATED_SYSTEM -> {
                SuccessfullyCreatedSystemController modal = loader.getController();
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(this.stage);
                dialog.setTitle("Successfully created");
                dialog.setResizable(false);
            }
            case SUCCESSFULLY_DELETED_SYSTEM -> {
                SuccessfullyDeletedSystemController modal = loader.getController();
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.initOwner(this.stage);
                dialog.setTitle("System deleted");
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

    public void goToPrevView(){
        visitViews.pop();
        openView(visitViews.peek());
    }

    public void openUpdateSystemView(UpdateSystemModel updateSystemModel){
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(LoggingManagerApp.class.getResource(Views.UPDATE_SYSTEM.toString()));

        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UpdateSystemController view = loader.getController();
        view.init(viewModelFactory.getUpdateSystemViewModel(updateSystemModel));
        stage.setResizable(false);
        stage.setTitle("Update System");
        visitViews.push(Views.UPDATE_SYSTEM);

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openErrorLogsView(int systemId,String systemName){
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(LoggingManagerApp.class.getResource(Views.ERROR_LOGS.toString()));

        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ErrorLogsController view = loader.getController();
        view.init(viewModelFactory.getErrorLogsViewModel(systemId,systemName));
        stage.setResizable(false);
        stage.setTitle("Error logs");
        visitViews.push(Views.ERROR_LOGS);

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openTrackingLogsView(int systemId,String systemName){
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(LoggingManagerApp.class.getResource(Views.TRACKING_LOGS.toString()));

        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        TrackingLogsController view = loader.getController();
        view.init(viewModelFactory.getTrackingLogsViewModel(systemId,systemName));
        stage.setResizable(false);
        stage.setTitle("Error logs");
        visitViews.push(Views.TRACKING_LOGS);

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openDeleteSystemModal(int systemId){
        dialog = new Stage();
        Scene scene = null;
        FXMLLoader loader = new FXMLLoader();
        Parent root = null;

        loader.setLocation(LoggingManagerApp.class.getResource(Views.DELETE_SYSTEM_MODAL.toString()));

        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        DeleteSystemController modal = loader.getController();
        modal.init(viewModelFactory.getDeleteSystemViewModel(systemId));
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.initOwner(this.stage);
        dialog.setTitle("Delete system");
        dialog.setResizable(false);

        scene = new Scene(root);
        dialog.setScene(scene);
        dialog.showAndWait();
    }
}
