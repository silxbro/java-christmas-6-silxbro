package christmas.constant;

import java.util.Arrays;

import static christmas.constant.MenuCategory.*;

public enum Menu {
    MUSHROOM_SOUP(APPETIZER, "양송이수프", 6_000),
    TAPAS(APPETIZER, "타파스", 5_500),
    CAESAR_SALAD(APPETIZER, "시저샐러드", 8_000),
    T_BONE_STEAK(MAIN, "티본스테이크", 55_000),
    BARBEQUE_LIB(MAIN, "바비큐립", 54_000),
    SEAFOOD_PASTA(MAIN, "해산물파스타", 35_000),
    CHRISTMAS_PASTA(MAIN, "크리스마스파스타", 25_000),
    CHOCOLATE_CAKE(DESERT, "초코케이크", 15_000),
    ICE_CREAM(DESERT, "아이스크림", 5_000),
    ZERO_COKE(DRINK, "제로콜라", 3_000),
    RED_WINE(DRINK, "레드와인", 60_000),
    CHAMPAGNE(DRINK, "샴페인", 25_000),
    ;

    private final MenuCategory type;
    private final String name;
    private final int price;

    Menu(MenuCategory type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public static Menu of(String name) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Error.INVALID_ORDER.getMessage()));
    }

    public MenuCategory getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
