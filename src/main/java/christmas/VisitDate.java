package christmas;

import christmas.constant.DayType;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDate {
    private static final int EVENT_YEAR = 2023;
    private static final int EVENT_MONTH = 12;
    public static final LocalDate CHRISTMAS = LocalDate.of(EVENT_YEAR, EVENT_MONTH, 25);

    private final LocalDate visitDate;

    public VisitDate(int day) {
        this.visitDate = LocalDate.of(EVENT_YEAR, EVENT_MONTH, day);
    }

    public int getDay() {
        return visitDate.getDayOfMonth();
    }

    public DayType getDayType() {
        if (visitDate.getDayOfWeek() == DayOfWeek.FRIDAY || visitDate.getDayOfWeek() == DayOfWeek.SATURDAY) {
            return DayType.WEEKEND;
        }
        return DayType.WEEKDAY;
    }

    public boolean hasStar() {
        return (visitDate.getDayOfWeek() == DayOfWeek.SUNDAY
                || visitDate.equals(CHRISTMAS));
    }

}
