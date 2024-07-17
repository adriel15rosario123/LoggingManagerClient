package com.rsc.loggingmanagerclient.factories;

import com.rsc.loggingmanagerclient.contracts.IAuthService;
import com.rsc.loggingmanagerclient.contracts.ISystemService;
import com.rsc.loggingmanagerclient.services.AuthService;
import com.rsc.loggingmanagerclient.services.SystemService;

public class ServiceFactory {

    private final IAuthService authService;

    private final ISystemService systemService;

    public ServiceFactory() {
        this.authService = new AuthService();
        this.systemService = new SystemService();
    }

    public IAuthService getAuthService(){
        return this.authService;
    }

    public ISystemService getSystemService(){
        return this.systemService;
    }

}
