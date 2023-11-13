package christmas.domain;

import christmas.constant.Menu;
import christmas.constant.MenuType;

import java.util.Map;

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

    public int getMenuTypeCount(MenuType menuType) {
        return menuBoard.entrySet().stream()
                .filter(entry -> entry.getKey().getType() == menuType)
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    public int getTotalAmount() {
        return menuBoard.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
