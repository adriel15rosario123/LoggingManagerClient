package com.rsc.loggingmanagerclient.contracts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rsc.loggingmanagerclient.dtos.CredentialDto;
import com.rsc.loggingmanagerclient.dtos.UserDto;
import com.rsc.loggingmanagerclient.exceptions.IncorrectCredentialException;

import java.io.IOException;
import java.net.ConnectException;

public interface IAuthService {
    UserDto login(CredentialDto credentialDto) throws Exception;
}
