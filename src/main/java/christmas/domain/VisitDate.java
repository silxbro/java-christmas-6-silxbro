package christmas.domain;

import christmas.constant.Error;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class VisitDate {
    public static final int EVENT_YEAR = 2023;
    public static final int EVENT_MONTH = 12;
    private static final VisitDate FIRST_DATE = new VisitDate(1);
    private static final VisitDate CHRISTMAS = new VisitDate(25);
    private final LocalDate date;

    public VisitDate(int dayNumber) {
        this.date = LocalDate.of(EVENT_YEAR, EVENT_MONTH, dayNumber);
    }

    public int getDayNumber() {
        return this.date.getDayOfMonth();
    }

    public boolean isAfterXmas() {
        return date.isAfter(CHRISTMAS.date);
    }

    public int getDaysSinceDecember1st() {
        return (int) ChronoUnit.DAYS.between(FIRST_DATE.date, date);
    }

    public boolean isWeekend() {
        return (date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY);
    }

    public boolean hasStar() {
        return (date.getDayOfWeek() == DayOfWeek.SUNDAY || date.equals(CHRISTMAS.date));
    }
}
