package com.rsc.loggingmanagerclient.contracts;

import com.rsc.loggingmanagerclient.models.Credential;
import com.rsc.loggingmanagerclient.models.User;

public interface IAuthService {
    User login(Credential credential);
}
