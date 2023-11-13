package christmas;

import christmas.constant.DayType;

import java.util.Map;

import static christmas.constant.DayType.*;
import static christmas.constant.Discount.*;
import static christmas.constant.MenuType.*;
import static christmas.VisitDate.*;

public class Benefit {

    public int getTotalDiscount(VisitDate date, Map<String, Integer> categoryFrequency) {
        return getDdayXmasDiscount(date.getDay())
                + getDayTypeDiscount(date.getDayType(), categoryFrequency)
                + getSpecialDiscount(date.hasStar());
    }
    private int getDdayXmasDiscount(int day) {
        if (day <= CHRISTMAS.getDayOfMonth()) {
            return XMAS_MIN.getAmount() + (day - 1) * XMAS_UNIT.getAmount();
        }
        return 0;
    }

    private int getDayTypeDiscount(DayType dayType, Map<String, Integer> categoryFrequency) {
        if (dayType == WEEKEND) {
            return categoryFrequency.get(MAIN) * DAYTYPE_UNIT.getAmount();
        }
        return categoryFrequency.get(DESERT) * DAYTYPE_UNIT.getAmount();
    }

    private int getSpecialDiscount(boolean hasStar) {
        return Boolean.compare(hasStar, false) * SPECIAL.getAmount();
    }
}
