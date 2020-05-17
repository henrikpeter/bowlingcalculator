package com.example.bowlingcalculator.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Points  implements Serializable {

    private ArrayList<List<Integer>> points = new ArrayList<>();
    private String token;


    public Points() {
        //default constructor
    }

    public ArrayList<List<Integer>> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<List<Integer>> points) {
        this.points = points;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
