package com.example.ninjabocil.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer
{
    private static final String BASE_URL ="https://publicapininjaheroes.vercel.app/";

    public static Retrofit retrofit;

    public static Retrofit getRetrofit (){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
