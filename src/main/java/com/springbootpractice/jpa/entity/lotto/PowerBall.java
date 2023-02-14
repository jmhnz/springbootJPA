package com.springbootpractice.jpa.entity.lotto;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PowerBall {
    public Integer powerballWinningNumber;
    public ArrayList<PowerballWinner> powerballWinners;
    public BigDecimal powerballPrizePool;
    public BigDecimal totalPowerballPrizes;
    public int powerballTotalWinners;

    public Integer getPowerballWinningNumber() {
        return powerballWinningNumber;
    }

    public void setPowerballWinningNumber(Integer powerballWinningNumber) {
        this.powerballWinningNumber = powerballWinningNumber;
    }

    public ArrayList<PowerballWinner> getPowerballWinners() {
        return powerballWinners;
    }

    public void setPowerballWinners(ArrayList<PowerballWinner> powerballWinners) {
        this.powerballWinners = powerballWinners;
    }

    public BigDecimal getPowerballPrizePool() {
        return powerballPrizePool;
    }

    public void setPowerballPrizePool(BigDecimal powerballPrizePool) {
        this.powerballPrizePool = powerballPrizePool;
    }

    public BigDecimal getTotalPowerballPrizes() {
        return totalPowerballPrizes;
    }

    public void setTotalPowerballPrizes(BigDecimal totalPowerballPrizes) {
        this.totalPowerballPrizes = totalPowerballPrizes;
    }

    public int getPowerballTotalWinners() {
        return powerballTotalWinners;
    }

    public void setPowerballTotalWinners(int powerballTotalWinners) {
        this.powerballTotalWinners = powerballTotalWinners;
    }
}
