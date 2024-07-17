package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.enums.Views;
import com.rsc.loggingmanagerclient.helpers.TokenHandler;

public class LogoutViewModel extends BaseViewModel{

    public void signOut(){
        TokenHandler.savePref("jwt","default");
        viewHandler.closeModal();
        viewHandler.openView(Views.LOGIN);
    }

    public void cancel(){
        viewHandler.closeModal();
    }
}
