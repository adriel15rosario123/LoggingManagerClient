package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.commands.UpdateSystemCommand;
import com.rsc.loggingmanagerclient.models.UpdateSystemModel;

public class UpdateSystemViewModel extends BaseViewModel {

    private UpdateSystemModel updateSystemModel;

    public UpdateSystemViewModel(UpdateSystemModel updateSystemModel) {
        this.updateSystemModel = updateSystemModel;
    }

    public UpdateSystemModel getUpdateSystemModel() {
        return updateSystemModel;
    }

    public void goToPrevView(){
        viewHandler.goToPrevView();
    }

    public void updateSystem(){
        UpdateSystemCommand command = new UpdateSystemCommand(updateSystemModel);
        command.execute();
    }
}
