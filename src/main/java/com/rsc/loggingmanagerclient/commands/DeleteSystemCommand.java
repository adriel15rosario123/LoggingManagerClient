package com.rsc.loggingmanagerclient.commands;

import com.rsc.loggingmanagerclient.dtos.BaseDto;
import com.rsc.loggingmanagerclient.enums.Views;
import javafx.application.Platform;
import javafx.concurrent.Task;

public class DeleteSystemCommand extends BaseCommand<BaseDto<String>> {

    private int systemId;

    public DeleteSystemCommand(int systemId) {
        this.systemId = systemId;

        setOnCommandSuccess(this::onSuccess);
        setOnCommandFailure(this::onFailure);
    }

    @Override
    protected Task<BaseDto<String>> createCommandTask() {
        return new Task<BaseDto<String>>() {
            @Override
            protected BaseDto<String> call() throws Exception {
                return getServices().getSystemService().DeleteSystem(systemId);
            }
        };
    }

    private void onSuccess() {
        //this.createSystemModel.cleanValues();
        getViewHandler().closeModal();
        getViewHandler().openView(Views.HOME);
        Platform.runLater(() -> getViewHandler().openModal(Views.SUCCESSFULLY_DELETED_SYSTEM));
    }

    private void onFailure() {
        //this.createSystemModel.setErrorMessage(getCommandTask().getException().getMessage());
        //getViewHandler().open(Views.HOME);
        getCommandTask().getException().printStackTrace();
    }
}
