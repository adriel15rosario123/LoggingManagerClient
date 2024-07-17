package com.rsc.loggingmanagerclient.commands;

import com.rsc.loggingmanagerclient.ViewHandler;
import com.rsc.loggingmanagerclient.factories.ServiceFactory;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;

public abstract class BaseCommand<T> {

    private final DoubleProperty progress;
    private final BooleanProperty running;
    private final ViewHandler viewHandler;
    private final ServiceFactory services;
    private Task<T> commandTask;
    private Runnable onCommandSuccess;
    private Runnable onCommandFailure;

    public BaseCommand() {
        this.progress = new SimpleDoubleProperty();
        this.running = new SimpleBooleanProperty();
        this.viewHandler = ViewHandler.getViewHandlerInstance();
        this.services = new ServiceFactory();
    }

    protected abstract Task<T> createCommandTask();

    public void setOnCommandSuccess(Runnable onCommandSuccess){
        this.onCommandSuccess = onCommandSuccess;
    }

    public void setOnCommandFailure(Runnable onCommandFailure){
        this.onCommandFailure = onCommandFailure;
    }

    public DoubleProperty progressProperty() {
        return progress;
    }

    public BooleanProperty runningProperty() {
        return running;
    }

    public ViewHandler getViewHandler() {
        return viewHandler;
    }

    public ServiceFactory getServices() {
        return services;
    }

    public Task<T> getCommandTask() {
        return commandTask;
    }

    public void execute(){
        this.commandTask = createCommandTask();

        running.bind(commandTask.runningProperty());
        progress.bind(commandTask.progressProperty());

        Thread thread = new Thread(commandTask);
        thread.setDaemon(true);
        thread.start();

        commandTask.setOnSucceeded(event -> {
            if (onCommandSuccess != null) {
                onCommandSuccess.run();
            }
        });

        commandTask.setOnFailed(event -> {
            if (onCommandFailure != null) {
                onCommandFailure.run();
            }
        });
    }
}
