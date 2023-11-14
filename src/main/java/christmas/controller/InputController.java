package christmas.controller;

import christmas.constant.Menu;
import christmas.view.InputView;
import christmas.validation.DayNumber;
import christmas.validation.MenuBoard;

import java.util.Map;

public class InputController {
    private final InputView inputView = new InputView();

    public int getDayNumber() {
        try {
            return DayNumber.validateRange(inputView.readDate());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getDayNumber();
        }
    }

    public Map<Menu, Integer> getMenuBoard() {
        try {
            return MenuBoard.validate(inputView.readOrder());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMenuBoard();
        }
    }
}
