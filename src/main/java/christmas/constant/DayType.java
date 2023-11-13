package christmas.constant;

public enum DayType {
    WEEKDAY("평일"),
    WEEKEND("주말");

    private final String korean;

    DayType(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return this.korean;
    }


}
