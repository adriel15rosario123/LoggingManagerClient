package com.rsc.loggingmanagerclient.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsc.loggingmanagerclient.dtos.TokenStatusDto;
import com.rsc.loggingmanagerclient.enums.ApiUrls;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.prefs.Preferences;

public class TokenHandler {

    private static Preferences pref = Preferences.userNodeForPackage(TokenHandler.class);

    public static void savePref(String prefKey,String prefValue){
        pref.put(prefKey,prefValue);
    }

    public static String getPref(String prefKey){
        return pref.get(prefKey,"default");
    }

    public static Boolean isTokenValid(){
        String accessToken = getPref("jwt");
        String url = ApiUrls.BASE_URL.toString()+ "auth/token/status?token="+accessToken;

        try(HttpClient client = HttpClient.newHttpClient()){

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();

            System.out.println(response.body());

            TokenStatusDto tokenStatusDto = objectMapper.readValue(response.body(), TokenStatusDto.class);

            return tokenStatusDto.getIsActive();

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

}
