package com.rsc.loggingmanagerclient.services.decorators;

import com.rsc.loggingmanagerclient.contracts.IAuthService;
import com.rsc.loggingmanagerclient.helpers.TokenHandler;
import com.rsc.loggingmanagerclient.models.Credential;
import com.rsc.loggingmanagerclient.models.User;
import com.rsc.loggingmanagerclient.services.AuthService;

public class AuthServiceDecorator implements IAuthService {

    private AuthService authService;

    public AuthServiceDecorator(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public User login(Credential credential) {

        User user = authService.login(credential);



        return null;
    }
}
