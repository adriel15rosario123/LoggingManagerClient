package com.rsc.loggingmanagerclient.commands;

import com.rsc.loggingmanagerclient.dtos.BaseDto;
import com.rsc.loggingmanagerclient.dtos.CreateSystemDto;
import com.rsc.loggingmanagerclient.enums.Views;
import com.rsc.loggingmanagerclient.models.CreateSystemModel;
import javafx.concurrent.Task;

public class CreateSystemCommand extends BaseCommand<BaseDto<String>> {

    private CreateSystemModel createSystemModel;

    public CreateSystemCommand(CreateSystemModel createSystemModel) {
        this.createSystemModel = createSystemModel;

        setOnCommandSuccess(this::onSuccess);
        setOnCommandFailure(this::onFailure);
    }

    @Override
    protected Task<BaseDto<String>> createCommandTask() {
        return new Task<>() {
            @Override
            protected BaseDto<String> call() throws Exception {

                CreateSystemDto createSystemDto = new CreateSystemDto(createSystemModel.getUsername(), createSystemModel.getPassword(), createSystemModel.getSystemName());

                return getServices().getSystemService().CreateSystem(createSystemDto);
            }
        };
    }

    private void onSuccess() {
       this.createSystemModel.cleanValues();
       getViewHandler().openModal(Views.SUCCESSFULLY_CREATED_SYSTEM);
    }

    private void onFailure() {
        this.createSystemModel.setErrorMessage(getCommandTask().getException().getMessage());
        getCommandTask().getException().printStackTrace();
    }
}
