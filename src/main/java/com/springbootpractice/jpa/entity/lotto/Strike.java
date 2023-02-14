package com.springbootpractice.jpa.entity.lotto;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Strike {
    public ArrayList<Integer> strikeWinningNumbers;
    public ArrayList<StrikeWinner> strikeWinners;
    public BigDecimal strikePrizePool;
    public BigDecimal totalStrikePrizes;
    public int strikeTotalWinners;

    public ArrayList<Integer> getStrikeWinningNumbers() {
        return strikeWinningNumbers;
    }

    public void setStrikeWinningNumbers(ArrayList<Integer> strikeWinningNumbers) {
        this.strikeWinningNumbers = strikeWinningNumbers;
    }

    public ArrayList<StrikeWinner> getStrikeWinners() {
        return strikeWinners;
    }

    public void setStrikeWinners(ArrayList<StrikeWinner> strikeWinners) {
        this.strikeWinners = strikeWinners;
    }

    public BigDecimal getStrikePrizePool() {
        return strikePrizePool;
    }

    public void setStrikePrizePool(BigDecimal strikePrizePool) {
        this.strikePrizePool = strikePrizePool;
    }

    public BigDecimal getTotalStrikePrizes() {
        return totalStrikePrizes;
    }

    public void setTotalStrikePrizes(BigDecimal totalStrikePrizes) {
        this.totalStrikePrizes = totalStrikePrizes;
    }

    public int getStrikeTotalWinners() {
        return strikeTotalWinners;
    }

    public void setStrikeTotalWinners(int strikeTotalWinners) {
        this.strikeTotalWinners = strikeTotalWinners;
    }
}
