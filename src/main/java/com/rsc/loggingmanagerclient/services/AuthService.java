package com.rsc.loggingmanagerclient.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsc.loggingmanagerclient.ViewHandler;
import com.rsc.loggingmanagerclient.contracts.IAuthService;
import com.rsc.loggingmanagerclient.dtos.*;
import com.rsc.loggingmanagerclient.enums.ApiUrls;
import com.rsc.loggingmanagerclient.enums.Views;
import com.rsc.loggingmanagerclient.exceptions.IncorrectCredentialException;
import com.rsc.loggingmanagerclient.helpers.TokenHandler;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class AuthService implements IAuthService {
    @Override
    public UserDto login(CredentialDto credentialDto) throws Exception {

        try(HttpClient client = HttpClient.newHttpClient()){

            ObjectMapper objectMapper = new ObjectMapper();

            String requestValues = objectMapper.writeValueAsString(credentialDto);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ApiUrls.BASE_URL+"auth/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestValues))
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            TypeReference<BaseDto<LoginDto>> typeRef = new TypeReference<>() {};

            BaseDto<LoginDto> login = objectMapper.readValue(response.body(), typeRef);

            if(login.getErrorCode() == null){
                TokenHandler.savePref("userId", String.valueOf(login.getData().getUser().getUserId()));
                TokenHandler.savePref("jwt",  login.getData().getToken().getKey());
                return login.getData().getUser();
            }else{
                throw new IncorrectCredentialException("Invalid credentials!!");
            }

        }
    }
}
