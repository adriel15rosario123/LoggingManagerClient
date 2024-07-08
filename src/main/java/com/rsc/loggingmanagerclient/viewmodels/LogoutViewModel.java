package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.enums.ViewEnum;

public class LogoutViewModel extends BaseViewModel{

    public void signOut(){
        try {
            viewHandler.closeModal();
            viewHandler.openView(ViewEnum.LOGIN);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cancel(){
        try {
            viewHandler.closeModal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
