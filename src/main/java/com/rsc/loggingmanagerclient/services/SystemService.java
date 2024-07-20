package com.rsc.loggingmanagerclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsc.loggingmanagerclient.contracts.ISystemService;
import com.rsc.loggingmanagerclient.dtos.BaseDto;
import com.rsc.loggingmanagerclient.dtos.CreateSystemDto;
import com.rsc.loggingmanagerclient.dtos.SystemDto;
import com.rsc.loggingmanagerclient.dtos.UpdateSystemDto;
import com.rsc.loggingmanagerclient.enums.ApiUrls;
import com.rsc.loggingmanagerclient.exceptions.UserAlreadyExistException;
import com.rsc.loggingmanagerclient.helpers.TokenHandler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class SystemService implements ISystemService {
    @Override
    public List<SystemDto> getAll() {

        String accessToken = TokenHandler.getPref("jwt");
        String url = ApiUrls.BASE_URL+ "systems";

        try(HttpClient httpClient = HttpClient.newHttpClient()){

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization","Bearer "+accessToken)
                    .build();

            // Send the request and get the response
            HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(httpResponse.body());

            ObjectMapper objectMapper = new ObjectMapper();

            TypeReference<BaseDto<List<SystemDto>>> typeRef = new TypeReference<>() {};

            BaseDto<List<SystemDto>> response = objectMapper.readValue(httpResponse.body(),typeRef);

            return response.getData();

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public BaseDto<String> CreateSystem(CreateSystemDto createSystemDto) throws Exception {

        String accessToken = TokenHandler.getPref("jwt");
        String url = ApiUrls.BASE_URL+ "systems";

        try(HttpClient httpClient = HttpClient.newHttpClient()){

            ObjectMapper objectMapper = new ObjectMapper();

            String requestValues = objectMapper.writeValueAsString(createSystemDto);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization","Bearer "+accessToken)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestValues))
                    .build();

            // Send the request and get the response
            HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            TypeReference<BaseDto<String>> typeRef = new TypeReference<>() {};

            BaseDto<String> response = objectMapper.readValue(httpResponse.body(),typeRef);

            if(response.getErrorCode() == null){
                return response;
            }
            else if(response.getErrorCode() == -1){
                throw new UserAlreadyExistException("Username already exist!!");
            }else{
                throw new Exception("Something went wrong :(");
            }
        }

    }

    @Override
    public BaseDto<String> UpdateSystem(int systemId,UpdateSystemDto updateSystemDto) throws Exception {
        String accessToken = TokenHandler.getPref("jwt");
        String url = ApiUrls.BASE_URL+ "systems/"+systemId;

        try(HttpClient httpClient = HttpClient.newHttpClient()){

            ObjectMapper objectMapper = new ObjectMapper();

            String requestValues = objectMapper.writeValueAsString(updateSystemDto);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .method("PATCH",HttpRequest.BodyPublishers.ofString(requestValues))
                    .header("Authorization","Bearer "+accessToken)
                    .header("Content-Type", "application/json")
                    .build();

            // Send the request and get the response
            HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            TypeReference<BaseDto<String>> typeRef = new TypeReference<>() {};

            BaseDto<String> response = objectMapper.readValue(httpResponse.body(),typeRef);

            if(response.getErrorCode() == null){
                return response;
            }
            else if(response.getErrorCode() == -1){
                throw new UserAlreadyExistException("Username already exist!!");
            }else{
                throw new Exception("Something went wrong :(");
            }
        }
    }
}
