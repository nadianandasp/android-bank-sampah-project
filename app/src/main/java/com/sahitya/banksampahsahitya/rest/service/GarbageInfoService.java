package com.sahitya.banksampahsahitya.rest.service;

import com.sahitya.banksampahsahitya.model.GarbageInfoModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GarbageInfoService {
    @GET("info_sampah")
    Call<ArrayList<GarbageInfoModel>> getInfoSampah();
}
