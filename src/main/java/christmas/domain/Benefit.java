package christmas.domain;

import static christmas.constant.Amount.*;
import static christmas.constant.MenuCategory.*;

public class Benefit {

    public int getTotalBenefit(VisitDate date, Order order) {
        int ddayXmasDiscount = getDdayXmasDiscount(date);
        int weekdayDiscount = getWeekdayDiscount(date.isWeekend(), order);
        int weekendDiscount = getWeekendDiscount(date.isWeekend(), order);
        int specialDiscount = getSpecialDiscount(date.hasStar());
        int giftAmount = getGiftAmount(order.canGetGift());

        if (order.canGetBenefit()) {
            return ddayXmasDiscount + weekdayDiscount + weekendDiscount + specialDiscount + giftAmount;
        }
        return 0;
    }


    public int getDdayXmasDiscount(VisitDate date) {
        if (!date.isAfterXmas()) {
            return XMAS_DISCOUNT_MIN.getAmount() + date.getDaysSinceDecember1st() * XMAS_DISCOUNT_UNIT.getAmount();
        }
        return 0;
    }

    public int getWeekdayDiscount(boolean isWeekend, Order order) {
        if (!isWeekend) {
            return order.getMenuTypeCount(DESERT) * WEEKDAY_DISCOUNT_UNIT.getAmount();
        }
        return 0;
    }

    public int getWeekendDiscount(boolean isWeekend, Order order) {
        if (isWeekend) {
            return order.getMenuTypeCount(MAIN) * WEEKEND_DISCOUNT_UNIT.getAmount()
        }
        return 0;
    }

    public int getSpecialDiscount(boolean hasStar) {
        if (hasStar) {
            return SPECIAL_DISCOUNT.getAmount();
        }
        return 0;
    }

    public int getGiftAmount(boolean canGetGift) {
        if (canGetGift) {
            return GIFT_BENEFIT.getAmount();
        }
        return 0;
    }
}
