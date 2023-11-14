package christmas.controller;

import christmas.view.InputView;
import validation.DayNumber;

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
}
