package com.sahitya.banksampahsahitya.model;

import com.google.gson.annotations.SerializedName;

public class GarbageInfoModel {
    @SerializedName("id")
    private int id;

    @SerializedName("kategori")
    private String kategori;

    @SerializedName("nama")
    private String nama;

    @SerializedName("harga_per_kilo")
    private int hargaPerKilo;

    public GarbageInfoModel(){
    }

    public GarbageInfoModel(int id, String kategori, String nama, int hargaPerKilo) {
        this.id = id;
        this.kategori = kategori;
        this.nama = nama;
        this.hargaPerKilo = hargaPerKilo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHargaPerKilo() {
        return hargaPerKilo;
    }

    public void setHargaPerKilo(int hargaPerKilo) {
        this.hargaPerKilo = hargaPerKilo;
    }
}
