package christmas.controller;

import christmas.domain.Order;
import christmas.domain.VisitDate;
import christmas.view.OutputView;

public class EventPlanner {
    private final InputController inputController;
    private final OutputView outputView;

    public EventPlanner() {
        this.inputController = new InputController();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();

        VisitDate visitDate = new VisitDate(inputController.getDayNumber());
        Order order = new Order(inputController.getMenuBoard());

        outputView.printResult(visitDate, order);
    }
}
