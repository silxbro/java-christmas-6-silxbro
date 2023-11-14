package christmas.constant;

import java.util.Arrays;
import java.util.Comparator;

public enum Badge {
    SANTA("산타", 20_000),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    NO_BADGE("없음", 0);

    private final String korean;
    private final int amountCondition;

    Badge(String korean, int amountCondition) {
        this.korean = korean;
        this.amountCondition = amountCondition;
    }

    public static Badge of(int amount) {
        Badge[] badges = Badge.values();
        Arrays.sort(badges, badgeComparator().reversed());
        for (Badge badge : badges) {
            if (amount >= badge.amountCondition) {
                return badge;
            }
        }
        return Badge.NO_BADGE;
    }

    public String getKorean() {
        return this.korean;
    }

    public int getAmountCondition() {
        return this.amountCondition;
    }

    public static Comparator<Badge> badgeComparator() {
        return Comparator.comparingInt(Badge::getAmountCondition);
    }
}
