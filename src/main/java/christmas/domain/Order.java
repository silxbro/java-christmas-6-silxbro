package christmas.domain;

import christmas.constant.Menu;
import christmas.constant.MenuCategory;

import java.util.Map;

import static christmas.constant.Amount.*;

public class Order {
    private final Map<Menu, Integer> menuBoard;

    public Order(Map<Menu, Integer> menuBoard) {
        this.menuBoard = menuBoard;
    }

    public int getTotalCount() {
        return menuBoard.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getMenuCategoryCount(MenuCategory menuCategory) {
        return menuBoard.entrySet().stream()
                .filter(entry -> entry.getKey().getType() == menuCategory)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public int getTotalAmount() {
        return menuBoard.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public boolean canGetBenefit() {
        return (getTotalAmount() >= TOTAL_BENEFIT_CONDITION.getAmount());
    }

    public boolean canGetGift() {
        return (getTotalAmount() >= GIFT_BENEFIT_CONDITION.getAmount());
    }
}
