package christmas;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDate {
    private final LocalDate visitDate;

    public VisitDate(int day) {
        this.visitDate = LocalDate.of(2023, 12, day);
    }

    public int getDay() {
        return visitDate.getDayOfMonth();
    }

    public boolean isWeekend() {
        DayOfWeek dayOfWeek = visitDate.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY) {
            return true;
        }
        return false;
    }

    public boolean isSpecialDay() {
        if (visitDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return true;
        }
        if (visitDate == LocalDate.of(2023, 12, 25)) {
            return true;
        }
        return false;
    }

}
