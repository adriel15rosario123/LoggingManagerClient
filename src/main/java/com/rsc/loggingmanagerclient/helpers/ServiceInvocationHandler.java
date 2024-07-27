package com.rsc.loggingmanagerclient.helpers;

import com.rsc.loggingmanagerclient.contracts.IAuthService;
import com.rsc.loggingmanagerclient.dtos.CredentialDto;
import com.rsc.loggingmanagerclient.services.AuthService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceInvocationHandler implements InvocationHandler {

    private Object realService;

    public ServiceInvocationHandler(Object realService) {
        this.realService = realService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(!TokenHandler.isTokenValid()){
            //login
            CredentialDto credentialDto = new CredentialDto(TokenHandler.getPref("username"),TokenHandler.getPref("password"));
            IAuthService authService = new AuthService();
            authService.login(credentialDto);
            System.out.println("token refresh...");
        }
        return method.invoke(realService, args);
    }


}
