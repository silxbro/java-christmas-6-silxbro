package christmas.constant;

public enum MenuCategory {
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESERT("디저트"),
    DRINK("음료"),
    ;

    private final String name;

    MenuCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
