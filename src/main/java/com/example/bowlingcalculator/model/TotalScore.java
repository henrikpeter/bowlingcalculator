package com.example.bowlingcalculator.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TotalScore implements Serializable {

    private String token;
    private List<Integer> toalScore = new ArrayList<>();

    public TotalScore() {
        //default constructor
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Integer> getToalScore() {
        return toalScore;
    }

    public void setToalScore(List<Integer> toalScore) {
        this.toalScore = toalScore;
    }
}
