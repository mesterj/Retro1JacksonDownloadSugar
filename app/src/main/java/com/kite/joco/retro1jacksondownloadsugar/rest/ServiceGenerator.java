package com.kite.joco.retro1jacksondownloadsugar.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.JacksonConverter;

/**
 * Created by Joco on 2015.11.28..
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "http://192.168.1.107:8080/NyomtServ2-1.0/webresources";
    //public static final String API_BASE_URL = "http://192.168.86.3:8080/NyomtServ2-1.0/webresources";

    private static RestAdapter.Builder builder = new RestAdapter.Builder()
            .setConverter(new JacksonConverter(new ObjectMapper()))
            .setEndpoint(API_BASE_URL)
            .setClient(new OkClient(new OkHttpClient()));

    public static <S> S createService(Class<S> serviceClass) {
        RestAdapter adapter = builder.build();
        return adapter.create(serviceClass);
    }
}