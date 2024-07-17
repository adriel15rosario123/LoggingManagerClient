package com.rsc.loggingmanagerclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsc.loggingmanagerclient.contracts.ISystemService;
import com.rsc.loggingmanagerclient.dtos.BaseDto;
import com.rsc.loggingmanagerclient.dtos.SystemDto;
import com.rsc.loggingmanagerclient.enums.ApiUrls;
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
}
