package christmas.constant;

import static christmas.constant.Menu.*;

public enum Amount {
    XMAS_DISCOUNT_MIN(1000),
    XMAS_DISCOUNT_UNIT(100),
    WEEKDAY_DISCOUNT_UNIT(2023),
    WEEKEND_DISCOUNT_UNIT(2023),
    SPECIAL_DISCOUNT(1000),
    GIFT_BENEFIT(CHAMPAGNE.getPrice()),
    GIFT_BENEFIT_CONDITION(120000),
    TOTAL_BENEFIT_CONDITION(10000);

    private final int amount;

    Amount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }


}
