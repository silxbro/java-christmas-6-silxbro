package christmas.domain;

import christmas.constant.Menu;
import christmas.constant.MenuCategory;

import java.util.Map;

public class Order {
    private static final int BENEFIT_CONDITION = 10000;
    private static final int GIFT_CONDITION = 120000;
    private final Map<Menu, Integer> menuBoard;

    public Order(Map<Menu, Integer> menuBoard) {
        this.menuBoard = menuBoard;
    }

    public Map<Menu, Integer> getMenuBoard() {
        return this.menuBoard;
    }

    public int getCategoryCount(MenuCategory category) {
        return menuBoard.entrySet().stream()
                .filter(entry -> entry.getKey().getType() == category)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public int getTotalAmount() {
        return menuBoard.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public boolean canGetBenefit() {
        return getTotalAmount() >= BENEFIT_CONDITION;
    }

    public boolean canGetGift() {
        return getTotalAmount() >= GIFT_CONDITION;
    }
}
