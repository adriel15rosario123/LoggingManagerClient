package com.rsc.loggingmanagerclient.factories;

import com.rsc.loggingmanagerclient.contracts.IAuthService;
import com.rsc.loggingmanagerclient.contracts.ISystemService;
import com.rsc.loggingmanagerclient.helpers.ServiceInvocationHandler;
import com.rsc.loggingmanagerclient.services.AuthService;
import com.rsc.loggingmanagerclient.services.SystemService;

import java.lang.reflect.Proxy;

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

        return (ISystemService) Proxy.newProxyInstance(
                ISystemService.class.getClassLoader(),
                new Class<?>[] {ISystemService.class},
                new ServiceInvocationHandler(systemService)
        );
    }

}
