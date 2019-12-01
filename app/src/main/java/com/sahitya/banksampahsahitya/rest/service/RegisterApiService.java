package com.sahitya.banksampahsahitya.rest.service;

import com.sahitya.banksampahsahitya.model.RegistersModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterApiService {
    @POST("daftar")
    @FormUrlEncoded
    Call<RegistersModel> saveRegisterPost(
        @Field("name") String name,
        @Field("email") String email,
        @Field("password") String password,
        @Field("password_confirmation") String password_confirmation,
        @Field("nim") String nim,
        @Field("fakultas") String fakultas,
        @Field("jurusan") String jurusan,
        @Field("hp") String hp,
        @Field("alamat") String alamat,
        @Field("tanggal_lahir") String tanggal_lahir
    );
}