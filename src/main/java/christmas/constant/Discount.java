package christmas.constant;

import static christmas.constant.Menu.*;

public enum Discount {
    XMAS("크리스마스 디데이 할인", 1000, 100),
    WEEKDAY("평일 할인", 0, 2023),
    WEEKEND("주말 할인", 0, 2023),
    SPECIAL("특별 할인", 1000,0),
    GIFT("증정 이벤트", CHAMPAGNE.getPrice(), 0),
    ;

    private final String name;
    private final int initialAmount;
    private final int unitAmount;

    Discount(String name, int initialAmount, int unitAmount) {
        this.name = name;
        this.initialAmount = initialAmount;
        this.unitAmount = unitAmount;
    }

    public String getName() {
        return this.name;
    }

    public int getInitialAmount() {
        return this.initialAmount;
    }

    public int getUnitAmount() {
        return this.unitAmount;
    }
}
