package com.sahitya.banksampahsahitya.rest.service;

import com.sahitya.banksampahsahitya.model.ranking.RankingResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RankingService {
    @GET("ranking")
    Call<RankingResponseModel> getRanking();
}
