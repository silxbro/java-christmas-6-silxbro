package christmas.domain;

import christmas.constant.Discount;

import java.util.HashMap;
import java.util.Map;

import static christmas.constant.Discount.*;
import static christmas.constant.MenuCategory.*;

public class Benefit {
    private final VisitDate date;
    private final Order order;

    public Benefit(VisitDate date, Order order) {
        this.date = date;
        this.order = order;
    }

    public int getTotalBenefit() {
        return getTotalDiscount() + getGiftAmount();
    }
    private int getTotalDiscount() {
        if (order.canGetBenefit()) {
            return getDdayXmasDiscount() + getWeekdayDiscount() + getWeekendDiscount() + getSpecialDiscount();
        }
        return 0;
    }

    public int getBenefitedTotalAmount() {
        return order.getTotalAmount() - getTotalDiscount();
    }

    public Map<Discount, Integer> getBenefitBoard() {
        Map<Discount, Integer> board = new HashMap<>();
        board.put(XMAS, getDdayXmasDiscount());
        board.put(WEEKDAY, getWeekdayDiscount());
        board.put(WEEKEND, getWeekendDiscount());
        board.put(SPECIAL, getSpecialDiscount());
        board.put(GIFT, getGiftAmount());

        return board;
    }

    private int getDdayXmasDiscount() {
        if (!date.isAfterXmas()) {
            return XMAS.getInitialAmount() + date.getDaysSinceDecember1st() * XMAS.getUnitAmount();
        }
        return 0;
    }

    private int getWeekdayDiscount() {
        if (!date.isWeekend()) {
            return order.getCategoryCount(DESERT) * WEEKDAY.getUnitAmount();
        }
        return 0;
    }

    private int getWeekendDiscount() {
        if (date.isWeekend()) {
            return order.getCategoryCount(MAIN) * WEEKEND.getUnitAmount();
        }
        return 0;
    }

    private int getSpecialDiscount() {
        if (date.hasStar()) {
            return SPECIAL.getInitialAmount();
        }
        return 0;
    }

    private int getGiftAmount() {
        if (order.canGetGift()) {
            return GIFT.getInitialAmount();
        }
        return 0;
    }
}