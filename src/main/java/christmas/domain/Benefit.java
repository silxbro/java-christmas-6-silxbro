package christmas.domain;

import christmas.constant.DayType;

import static christmas.constant.DayType.*;
import static christmas.constant.Discount.*;
import static christmas.constant.MenuType.*;
import static christmas.domain.VisitDate.*;

public class Benefit {

    public int getTotalDiscount(VisitDate date, Order order) {
        return getDdayXmasDiscount(date.getDay())
                + getDayTypeDiscount(date.getDayType(), order)
                + getSpecialDiscount(date.hasStar());
    }
    public int getDdayXmasDiscount(int day) {
        if (day <= CHRISTMAS.getDayOfMonth()) {
            return XMAS_MIN.getAmount() + (day - 1) * XMAS_UNIT.getAmount();
        }
        return 0;
    }

    public int getDayTypeDiscount(DayType dayType, Order order) {
        if (dayType == WEEKEND) {
            return order.getMenuTypeCount(MAIN) * DAYTYPE_UNIT.getAmount();
        }
        return order.getMenuTypeCount(DESERT) * DAYTYPE_UNIT.getAmount();
    }

    public int getSpecialDiscount(boolean hasStar) {
        return Boolean.compare(hasStar, false) * SPECIAL.getAmount();
    }
}
