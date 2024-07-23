package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.commands.DeleteSystemCommand;

public class DeleteSystemViewModel extends BaseViewModel{

    private int systemId;

    public DeleteSystemViewModel(int systemId) {
        this.systemId = systemId;
    }

    public void deleteSystem(){
        DeleteSystemCommand command = new DeleteSystemCommand(systemId);
        command.execute();
    }

    public void cancel(){
        viewHandler.closeModal();
    }
}
