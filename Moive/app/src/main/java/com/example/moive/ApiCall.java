package com.example.moive;

public class ApiCall {
    public static String link="http://www.omdbapi.com/";

    public static ApiRequest getApiRequest(){
        return RetrofitClient.getClient(link).create(ApiRequest.class);
    }

}
