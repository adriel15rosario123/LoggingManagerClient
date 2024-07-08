package com.rsc.loggingmanagerclient;

import com.rsc.loggingmanagerclient.factories.ServiceFactory;
import com.rsc.loggingmanagerclient.factories.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class LoggingManagerApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ServiceFactory serviceFactory = new ServiceFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(serviceFactory);
        ViewHandler viewHandler = ViewHandler.getViewHandlerInstance(stage,viewModelFactory);
        viewHandler.start();
    }

}