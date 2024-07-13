package com.rsc.loggingmanagerclient.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsc.loggingmanagerclient.contracts.ISystemService;
import com.rsc.loggingmanagerclient.dtos.ApiResponse;
import com.rsc.loggingmanagerclient.dtos.EnrollSystem;
import com.rsc.loggingmanagerclient.enums.ApiUrl;
import com.rsc.loggingmanagerclient.helpers.TokenHandler;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class SystemService implements ISystemService {
    @Override
    public List<EnrollSystem> getAll() {

        String accessToken = TokenHandler.getPref("jwt");
        String url = ApiUrl.BASE_URL.toString()+ "systems";

        try(HttpClient httpClient = HttpClient.newHttpClient()){

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Authorization","Bearer "+accessToken)
                    .build();

            // Send the request and get the response
            HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(httpResponse.body());

            ObjectMapper objectMapper = new ObjectMapper();

            TypeReference<ApiResponse<List<EnrollSystem>>> typeRef = new TypeReference<>() {};

            ApiResponse<List<EnrollSystem>> response = objectMapper.readValue(httpResponse.body(),typeRef);

            return response.getResponseData();

        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
