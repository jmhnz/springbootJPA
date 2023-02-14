package com.springbootpractice.jpa.entity.lotto;

public class PowerballWinner {
    public String prizeValue;
    public int numberOfWinners;
    public int division;
    public String combinedPrizeValue;

    public String getPrizeValue() {
        return prizeValue;
    }

    public void setPrizeValue(String prizeValue) {
        this.prizeValue = prizeValue;
    }

    public int getNumberOfWinners() {
        return numberOfWinners;
    }

    public void setNumberOfWinners(int numberOfWinners) {
        this.numberOfWinners = numberOfWinners;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public String getCombinedPrizeValue() {
        return combinedPrizeValue;
    }

    public void setCombinedPrizeValue(String combinedPrizeValue) {
        this.combinedPrizeValue = combinedPrizeValue;
    }
}
