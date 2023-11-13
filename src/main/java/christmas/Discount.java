package christmas;

public enum Discount {
    XMAS_MIN(1000),
    XMAS_UNIT(100),
    DAYTYPE_UNIT(2023),
    SPECIAL(1000);

    private final int amount;

    Discount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }


}
