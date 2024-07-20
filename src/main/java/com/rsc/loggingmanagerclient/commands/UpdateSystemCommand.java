package com.rsc.loggingmanagerclient.commands;

import com.rsc.loggingmanagerclient.dtos.BaseDto;
import com.rsc.loggingmanagerclient.dtos.UpdateSystemDto;
import com.rsc.loggingmanagerclient.enums.Views;
import com.rsc.loggingmanagerclient.models.UpdateSystemModel;
import javafx.concurrent.Task;

public class UpdateSystemCommand extends BaseCommand<BaseDto<String>> {

    private UpdateSystemModel updateSystemModel;

    public UpdateSystemCommand(UpdateSystemModel updateSystemModel) {
        this.updateSystemModel = updateSystemModel;

        setOnCommandSuccess(this::onSuccess);
        setOnCommandFailure(this::onFailure);
    }

    @Override
    protected Task<BaseDto<String>> createCommandTask() {
        return new Task<BaseDto<String>>() {
            @Override
            protected BaseDto<String> call() throws Exception {

                UpdateSystemDto updateSystemDto = new UpdateSystemDto(updateSystemModel.getUsername(), updateSystemModel.getPassword(), updateSystemModel.getSystemName());

                return getServices().getSystemService().UpdateSystem(updateSystemModel.getSystemId(),updateSystemDto);
            }
        };
    }

    private void onSuccess() {
        this.updateSystemModel.cleanValues();
        getViewHandler().openModal(Views.SUCCESSFULLY_UPDATED_SYSTEM);
    }

    private void onFailure() {
        this.updateSystemModel.setErrorMessage(getCommandTask().getException().getMessage());
        getCommandTask().getException().printStackTrace();
    }
}
