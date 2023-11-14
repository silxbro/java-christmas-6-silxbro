package christmas.validation;

import christmas.constant.Error;
import christmas.constant.Menu;
import christmas.constant.MenuCategory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MenuBoard {
    private static final int COUNT_LIMIT = 20;
    private final Map<Menu, Integer> menuBoard;

    public MenuBoard(Map<Menu, Integer> menuBoard) {
        this.menuBoard = menuBoard;
    }

    public static Map<Menu, Integer> validate(String orderString) {
        Map<Menu, Integer> board = new HashMap<>();
        try {
            Arrays.stream(orderString.split(","))
                    .forEach(order -> putInMap(order, board));
            validateOnlyDrink(board);
            validateCount(board);
            return board;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static void putInMap(String input, Map<Menu, Integer> board) {
        Menu menu = Menu.of(input.split("-")[0]);
        int count = Integer.parseInt(input.split("-")[1]);
        validateDuplicates(menu, board);
        board.put(menu, count);
    }

    private static void validateDuplicates(Menu menu, Map<Menu, Integer> board) {
        if (board.containsKey(menu)) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static void validateOnlyDrink(Map<Menu, Integer> board) {
        if (board.keySet().stream().allMatch(key -> key.getType() == MenuCategory.DRINK)) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }
    private static void validateCount(Map<Menu, Integer> board) {
        int totalCount = board.values().stream().mapToInt(Integer::intValue).sum();
        if (totalCount > COUNT_LIMIT) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }
}
