package com.springbootpractice.jpa.entity.lotto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Lotto {
    public int drawNumber;
    public WeekDays drawDay;
    public Date drawDate;
    public String drawTime;
    public LottoWinningNumbers lottoWinningNumbers;
    public ArrayList<LottoWinner> lottoWinners;
    public BigDecimal lottoPrizePool;
    public BigDecimal totalLottoPrizes;
    public int lottoTotalWinners;

    public int getDrawNumber() {
        return drawNumber;
    }

    public void setDrawNumber(int drawNumber) {
        this.drawNumber = drawNumber;
    }

    public WeekDays getDrawDay() {
        return drawDay;
    }

    public void setDrawDay(WeekDays drawDay) {
        this.drawDay = drawDay;
    }

    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }

    public String getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(String drawTime) {
        this.drawTime = drawTime;
    }

    public LottoWinningNumbers getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }

    public void setLottoWinningNumbers(LottoWinningNumbers lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public ArrayList<LottoWinner> getLottoWinners() {
        return lottoWinners;
    }

    public void setLottoWinners(ArrayList<LottoWinner> lottoWinners) {
        this.lottoWinners = lottoWinners;
    }

    public BigDecimal getLottoPrizePool() {
        return lottoPrizePool;
    }

    public void setLottoPrizePool(BigDecimal lottoPrizePool) {
        this.lottoPrizePool = lottoPrizePool;
    }

    public BigDecimal getTotalLottoPrizes() {
        return totalLottoPrizes;
    }

    public void setTotalLottoPrizes(BigDecimal totalLottoPrizes) {
        this.totalLottoPrizes = totalLottoPrizes;
    }

    public int getLottoTotalWinners() {
        return lottoTotalWinners;
    }

    public void setLottoTotalWinners(int lottoTotalWinners) {
        this.lottoTotalWinners = lottoTotalWinners;
    }
}
