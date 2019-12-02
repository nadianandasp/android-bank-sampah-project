package com.sahitya.banksampahsahitya.model;

public class DisburmentModel {

    private String tvAmount;
    private String tvTime;
    private String tvDate;

    public DisburmentModel(String tvAmount, String tvTime, String tvDate) {
        this.tvAmount = tvAmount;
        this.tvTime = tvTime;
        this.tvDate = tvDate;
    }

    public String getTvAmount() {
        return tvAmount;
    }

    public void setTvAmount(String tvAmount) {
        this.tvAmount = tvAmount;
    }

    public String getTvTime() {
        return tvTime;
    }

    public void setTvTime(String tvTime) {
        this.tvTime = tvTime;
    }

    public String getTvDate() {
        return tvDate;
    }

    public void setTvDate(String tvDate) {
        this.tvDate = tvDate;
    }

}
