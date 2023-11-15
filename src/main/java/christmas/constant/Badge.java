package christmas.constant;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NO_BADGE("없음", 0),
    ;

    private final String name;
    private final int amountCondition;

    Badge(String name, int amountCondition) {
        this.name = name;
        this.amountCondition = amountCondition;
    }

    public static Badge of(int amount) {
        return Arrays.stream(values())
                .filter(badge -> amount >= badge.amountCondition)
                .findFirst()
                .orElse(NO_BADGE);
    }

    public String getName() {
        return this.name;
    }
}
