package com.springbootpractice.jpa.entity.lotto;

public enum WeekDays {
        Mon(1),
        Tue(2),
        Wed(3),
        Thu(4),
        Fri(5),
        Sat(6),
        Sun(7);

    private Integer weekDay;

    WeekDays(int i) {
        this.weekDay = i;
    }

    public Integer getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(Integer weekDay) {
        this.weekDay = weekDay;
    }
}
