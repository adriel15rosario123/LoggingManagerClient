package com.rsc.loggingmanagerclient.contracts;

import com.rsc.loggingmanagerclient.dtos.CredentialDto;
import com.rsc.loggingmanagerclient.dtos.UserDto;

public interface IAuthService {
    UserDto login(CredentialDto credentialDto);
}
