package com.rsc.loggingmanagerclient.views.modals;

import com.rsc.loggingmanagerclient.viewmodels.DeleteSystemViewModel;

public class DeleteSystemController {

    private DeleteSystemViewModel deleteSystemViewModel;

    public DeleteSystemController() {

    }

    public void init(DeleteSystemViewModel deleteSystemViewModel){
        this.deleteSystemViewModel = deleteSystemViewModel;
    }

    public void onDeleteClick(){
        this.deleteSystemViewModel.deleteSystem();
    }

    public void onCancelClick(){
        this.deleteSystemViewModel.cancel();
    }
}
