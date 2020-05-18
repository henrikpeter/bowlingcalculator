package com.example.bowlingcalculator.model;

public class Frame {

    private int pinsKnockedDownRollOne;
    private int pinsKnockedDownRollTwo;
    private int pinsKnockedDownExtraRoll;
    private int totalScore;
    private boolean strike;
    private boolean spare;
    private boolean extraRoll;

    public Frame() {
        //default constructor
    }

    public int getPinsKnockedDownRollOne() {
        return pinsKnockedDownRollOne;
    }

    public void setPinsKnockedDownRollOne(int pinsKnockedDownRollOne) {
        this.pinsKnockedDownRollOne = pinsKnockedDownRollOne;
    }

    public int getPinsKnockedDownRollTwo() {
        return pinsKnockedDownRollTwo;
    }

    public void setPinsKnockedDownRollTwo(int pinsKnockedDownRollTwo) {
        this.pinsKnockedDownRollTwo = pinsKnockedDownRollTwo;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isStrike() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public boolean isSpare() {
        return spare;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }

    public int getPinsKnockedDownExtraRoll() {
        return pinsKnockedDownExtraRoll;
    }

    public void setPinsKnockedDownExtraRoll(int pinsKnockedDownExtraRoll) {
        this.pinsKnockedDownExtraRoll = pinsKnockedDownExtraRoll;
    }

    public boolean isExtraRoll() {
        return extraRoll;
    }

    public void setExtraRoll(boolean extraRoll) {
        this.extraRoll = extraRoll;
    }
}
