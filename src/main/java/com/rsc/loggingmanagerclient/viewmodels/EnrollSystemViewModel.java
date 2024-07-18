package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.commands.CreateSystemCommand;
import com.rsc.loggingmanagerclient.models.CreateSystemModel;

public class EnrollSystemViewModel extends BaseViewModel {

    private CreateSystemModel createSystemModel;

    public EnrollSystemViewModel() {
        this.createSystemModel = new CreateSystemModel();
    }

    public CreateSystemModel getCreateSystemModel() {
        return createSystemModel;
    }

    public void goToPrevView(){
        viewHandler.goToPrevView();
    }

    public void createNewSystem(){
        CreateSystemCommand command = new CreateSystemCommand(createSystemModel);
        command.execute();
    }
}
