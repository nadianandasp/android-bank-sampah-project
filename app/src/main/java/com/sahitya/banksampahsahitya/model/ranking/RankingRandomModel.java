package com.sahitya.banksampahsahitya.model.ranking;

import com.google.gson.annotations.SerializedName;

public class RankingRandomModel{
    @SerializedName("pemenang_random_id")
    private int pemenangRandomId;

    @SerializedName("pemenang_random_name")
    private String pemenangRandomName;

    public RankingRandomModel(){
    }

    public int getPemenangRandomId() {
        return pemenangRandomId;
    }

    public void setPemenangRandomId(int pemenangRandomId) {
        this.pemenangRandomId = pemenangRandomId;
    }

    public String getPemenangRandomName() {
        return pemenangRandomName;
    }

    public void setPemenangRandomName(String pemenangRandomName) {
        this.pemenangRandomName = pemenangRandomName;
    }
}
