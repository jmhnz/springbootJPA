package com.springbootpractice.jpa.entity.lotto;

import java.util.ArrayList;

public class LottoWinningNumbers {
    public ArrayList<Integer> numbers;
    public Integer bonusBalls;
    public Integer powerballWinningNumber;

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer getBonusBalls() {
        return bonusBalls;
    }

    public void setBonusBalls(Integer bonusBalls) {
        this.bonusBalls = bonusBalls;
    }

    public Integer getPowerballWinningNumber() {
        return powerballWinningNumber;
    }

    public void setPowerballWinningNumber(Integer powerballWinningNumber) {
        this.powerballWinningNumber = powerballWinningNumber;
    }
}
