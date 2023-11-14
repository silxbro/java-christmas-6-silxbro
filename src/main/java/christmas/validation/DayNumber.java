package christmas.validation;

import christmas.constant.Error;

public enum DayNumber {
    FIRST(1),
    LAST(31),
    ;

    private final int dayNumber;

    DayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getDayNumber() {
        return this.dayNumber;
    }

    public static int validateRange(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(Error.INVALID_DATE.getMessage());
        }
        return number;
    }

    private static boolean isInRange(int number) {
        return (number >= FIRST.dayNumber && number <= LAST.dayNumber);
    }
}
