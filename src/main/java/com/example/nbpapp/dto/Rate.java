package com.example.nbpapp.dto;

public class Rate {
    private String no;
    private String effectiveDate;
    private Double mid;
    private double bid;
    private double ask;

    // konstruktory, gettery i settery

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }


    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }
}