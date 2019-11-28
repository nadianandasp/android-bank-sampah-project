package com.sahitya.banksampahsahitya.rest.service;

import com.sahitya.banksampahsahitya.model.LoginModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {
    @POST("masuk")
    @FormUrlEncoded
    Call<LoginModel> saveLoginPost(
            @Field("email") String email,
            @Field("password") String password
    );
}

