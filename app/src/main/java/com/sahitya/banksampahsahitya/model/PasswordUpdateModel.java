package com.sahitya.banksampahsahitya.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PasswordUpdateModel {
    @SerializedName("kode")
    @Expose
    private String kode;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("password_confirmation")
    @Expose
    private String konfirmasiPassword;

    public PasswordUpdateModel(){
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKonfirmasiPassword() {
        return konfirmasiPassword;
    }

    public void setKonfirmasiPassword(String konfirmasiPassword) {
        this.konfirmasiPassword = konfirmasiPassword;
    }
}
