package com.example.ninjabocil.api;

import com.example.ninjabocil.models.ninja;
import com.example.ninjabocil.models.skill;
import com.example.ninjabocil.models.tailed;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestData
{

    @GET("ninja")
    Call<List<ninja>> getNinja();

    @GET("skill")
    Call<List<skill>> getSkill();

    @GET("tailed")
    Call<List<tailed>> getTailed();

}
