package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.ViewHandler;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;

public class BaseViewModel {
    private DoubleProperty progress;
    private BooleanProperty isRunning;
    protected ViewHandler viewHandler;

    public BaseViewModel() {
        this.viewHandler = ViewHandler.getViewHandlerInstance();
        this.progress = new SimpleDoubleProperty();
        this.isRunning = new SimpleBooleanProperty();
    }

    protected <T> void executeTask(Task<T> task, Runnable onSuccess, Runnable onFailure) {
        isRunning.bind(task.runningProperty());
        progress.bind(task.progressProperty());

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();

        task.setOnSucceeded(event -> {
            onSuccess.run();
        });

        task.setOnFailed(event -> {
            onFailure.run();
        });
    }

    public DoubleProperty progressProperty() {
        return progress;
    }

    public BooleanProperty isRunningProperty() {
        return isRunning;
    }
}
