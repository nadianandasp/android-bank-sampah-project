package com.sahitya.banksampahsahitya.utils;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sahitya.banksampahsahitya.model.ranking.RankingModel;
import com.sahitya.banksampahsahitya.model.ranking.RankingRandomModel;
import com.sahitya.banksampahsahitya.model.ranking.RankingResponseModel;
import com.sahitya.banksampahsahitya.rest.client.ApiClient;
import com.sahitya.banksampahsahitya.rest.service.RankingService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RankingUtils extends ViewModel {
    private final String TAG = this.getClass().getSimpleName();

    private MutableLiveData<ArrayList<RankingModel>> mutableLiveDataRanking = new MutableLiveData<>();
    private MutableLiveData<ArrayList<RankingRandomModel>> mutableLiveDataRandom = new MutableLiveData<>();

    public void asyncRanking(){
        RankingService rankingService = ApiClient.getClient().create(RankingService.class);

        final ArrayList<RankingModel> rankingArrayList = new ArrayList<>();

        Call<RankingResponseModel> call = rankingService.getRanking();
        call.enqueue(new Callback<RankingResponseModel>() {
            @Override
            public void onResponse(Call<RankingResponseModel> call, Response<RankingResponseModel> response) {
                ArrayList<RankingModel> rankingList = response.body().getRanking();

                if (!response.isSuccessful()){
                    return;
                }

                for (RankingModel r : rankingList){
                    RankingModel rankingModel = new RankingModel();

                    rankingModel.setName(r.getName());
                    Log.d(TAG, r.getName());
                    rankingModel.setBerat(r.getBerat());
                    Log.d(TAG, String.valueOf(r.getBerat()));

                    rankingArrayList.add(rankingModel);
                }
                Log.d(TAG, "Number of ranking : " + rankingArrayList.size());

                mutableLiveDataRanking.postValue(rankingArrayList);
            }

            @Override
            public void onFailure(Call<RankingResponseModel> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    public LiveData<ArrayList<RankingModel>> getLiveDataRanking(){
        return mutableLiveDataRanking;
    }

    public LiveData<ArrayList<RankingRandomModel>> getLiveDataRandom(){
        return mutableLiveDataRandom;
    }
}