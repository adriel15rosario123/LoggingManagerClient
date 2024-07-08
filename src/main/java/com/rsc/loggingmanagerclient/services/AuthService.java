package com.rsc.loggingmanagerclient.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsc.loggingmanagerclient.contracts.IAuthService;
import com.rsc.loggingmanagerclient.dtos.LoginResponse;
import com.rsc.loggingmanagerclient.enums.ApiUrl;
import com.rsc.loggingmanagerclient.helpers.TokenHandler;
import com.rsc.loggingmanagerclient.models.Credential;
import com.rsc.loggingmanagerclient.models.User;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AuthService implements IAuthService {
    @Override
    public User login(Credential credential) {

        try(HttpClient client = HttpClient.newHttpClient()){

            ObjectMapper objectMapper = new ObjectMapper();

            String requestValues = objectMapper.writeValueAsString(credential);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ApiUrl.BASE_URL.toString()+"auth/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestValues))
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            LoginResponse login = objectMapper.readValue(response.body(),LoginResponse.class);

            if(login.getResponse().getResponseData() != null){
                TokenHandler.savePref("userId", String.valueOf(login.getResponse().getResponseData().getUserId()));
                TokenHandler.savePref("jwt",  login.getAccessToken());

                return login.getResponse().getResponseData();
            }else{
                return null;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
