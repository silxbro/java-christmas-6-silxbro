package christmas.constant;

public enum MenuCategory {
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESERT("디저트"),
    DRINK("음료");

    private final String korean;

    MenuCategory(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return this.korean;
    }
}
