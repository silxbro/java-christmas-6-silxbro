package christmas.domain;

import christmas.constant.DayType;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDate {
    private static final int EVENT_YEAR = 2023;
    private static final int EVENT_MONTH = 12;
    public static final LocalDate CHRISTMAS = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 25);

    private final LocalDate date;

    public VisitDate(int day) {
        this.date = LocalDate.of(EVENT_YEAR, EVENT_MONTH, day);
    }

    public int getDay() {
        return date.getDayOfMonth();
    }

    public DayType getDayType() {
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return DayType.WEEKEND;
        }
        return DayType.WEEKDAY;
    }

    public boolean hasStar() {
        return (date.getDayOfWeek() == DayOfWeek.SUNDAY || date.equals(CHRISTMAS));
    }
}
