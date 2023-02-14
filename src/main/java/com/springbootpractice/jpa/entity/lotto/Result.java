package com.springbootpractice.jpa.entity.lotto;

import java.math.BigDecimal;

public class Result {
    public Lotto lotto;
    public Strike strike;
    public PowerBall powerBall;
    public BigDecimal totalPrizePool;
    public BigDecimal totalPrizes;
    public BigDecimal totalNumberWinners;

    public Lotto getLotto() {
        return lotto;
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Strike getStrike() {
        return strike;
    }

    public void setStrike(Strike strike) {
        this.strike = strike;
    }

    public PowerBall getPowerBall() {
        return powerBall;
    }

    public void setPowerBall(PowerBall powerBall) {
        this.powerBall = powerBall;
    }

    public BigDecimal getTotalPrizePool() {
        return totalPrizePool;
    }

    public void setTotalPrizePool(BigDecimal totalPrizePool) {
        this.totalPrizePool = totalPrizePool;
    }

    public BigDecimal getTotalPrizes() {
        return totalPrizes;
    }

    public void setTotalPrizes(BigDecimal totalPrizes) {
        this.totalPrizes = totalPrizes;
    }

    public BigDecimal getTotalNumberWinners() {
        return totalNumberWinners;
    }

    public void setTotalNumberWinners(BigDecimal totalNumberWinners) {
        this.totalNumberWinners = totalNumberWinners;
    }
}
