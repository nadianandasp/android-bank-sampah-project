package com.sahitya.banksampahsahitya.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPasswordModel {
    @SerializedName("email")
    @Expose
    private String email;

    public ForgotPasswordModel(){
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
