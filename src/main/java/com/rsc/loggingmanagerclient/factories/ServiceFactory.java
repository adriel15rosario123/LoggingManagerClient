package com.rsc.loggingmanagerclient.factories;

import com.rsc.loggingmanagerclient.contracts.IAuthService;
import com.rsc.loggingmanagerclient.services.AuthService;

public class ServiceFactory {

    private final IAuthService authService;

    public ServiceFactory() {
        this.authService = new AuthService();
    }

    public IAuthService getUserService(){
        return this.authService;
    }

}
