package christmas.validation;

import christmas.constant.Error;
import christmas.constant.Menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.constant.MenuCategory.*;

public class MenuBoard {
    private static final int MAX_COUNT = 20;
    private final Map<Menu, Integer> menuBoard;

    public MenuBoard(Map<Menu, Integer> menuBoard) {
        this.menuBoard = menuBoard;
    }

    public static Map<Menu, Integer> validate(String orderString) {
        try {
            return stringToMap(orderString);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static Map<Menu, Integer> stringToMap(String string) {
        Map<Menu, Integer> board = new HashMap<>();
        List.of(string.split(","))
                .forEach(order -> putInMap(order, board));

        validateOnlyDrink(board);
        validateCount(board);

        return board;
    }

    private static void putInMap(String input, Map<Menu, Integer> board) {
        Menu menu = Menu.of(input.split("-")[0]);
        int count = Integer.parseInt(input.split("-")[1]);

        validateDuplicates(menu, board);
        validateRange(count);

        board.put(menu, count);
    }

    private static void validateDuplicates(Menu menu, Map<Menu, Integer> board) {
        if (board.containsKey(menu)) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static void validateRange(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static void validateOnlyDrink(Map<Menu, Integer> board) {
        if (board.keySet().stream().allMatch(key -> key.getType().equals(DRINK))) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static void validateCount(Map<Menu, Integer> board) {
        int totalCount = board.values().stream().mapToInt(Integer::intValue).sum();
        if (totalCount > MAX_COUNT) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }
}
