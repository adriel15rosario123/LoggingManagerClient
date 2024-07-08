package com.rsc.loggingmanagerclient.viewmodels;

import com.rsc.loggingmanagerclient.enums.ViewEnum;

public class HomeViewModel extends BaseViewModel{

    public void logout(){
        try {
            viewHandler.openModal(ViewEnum.LOGOUT_MODAL);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
