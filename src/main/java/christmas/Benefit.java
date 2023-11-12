package christmas;

import java.util.Map;

public class Benefit {

    public int getTotalDiscount(VisitDate date, Map<String, Integer> categoryFrequency) {
        return getIncreasingXmasDiscount(date.getDay())
                + getDayOfWeekDiscount(date.isWeekend(), categoryFrequency)
                + getSpecialDayDiscount(date.isSpecialDay());
    }

    private int getIncreasingXmasDiscount(int day) {
        return 1000 + (day - 1) * 100;
    }

    private int getDayOfWeekDiscount(boolean isWeekend, Map<String, Integer> categoryFrequency) {
        if (isWeekend) {
            return categoryFrequency.get("MAIN") * 2023;
        }
        return categoryFrequency.get("DESERT") * 2023;
    }

    private int getSpecialDayDiscount(boolean isSpecialDay) {
        return Boolean.compare(isSpecialDay, false) * 1000;
    }
}
