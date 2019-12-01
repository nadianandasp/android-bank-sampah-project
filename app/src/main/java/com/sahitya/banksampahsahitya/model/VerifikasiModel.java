package com.sahitya.banksampahsahitya.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifikasiModel {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("kode_verifikasi")
    @Expose
    private String kodeVerifikasi;

    public VerifikasiModel(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKodeVerifikasi() {
        return kodeVerifikasi;
    }

    public void setKodeVerifikasi(String kodeVerifikasi) {
        this.kodeVerifikasi = kodeVerifikasi;
    }
}
