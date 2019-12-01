package com.sahitya.banksampahsahitya.model.ranking;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RankingResponseModel {
    @SerializedName("season")
    private int season;

    @SerializedName("ranking")
    private ArrayList<RankingModel> ranking;

    @SerializedName("random")
    private RankingRandomModel random;

    public RankingResponseModel(int season, ArrayList<RankingModel> ranking, RankingRandomModel random) {
        this.season = season;
        this.ranking = ranking;
        this.random = random;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public ArrayList<RankingModel> getRanking() {
        return ranking;
    }

    public void setRanking(ArrayList<RankingModel> ranking) {
        this.ranking = ranking;
    }

    public RankingRandomModel getRandom() {
        return random;
    }

    public void setRandom(RankingRandomModel random) {
        this.random = random;
    }
}
