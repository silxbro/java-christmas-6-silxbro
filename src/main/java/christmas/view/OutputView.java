package christmas.view;

import christmas.constant.Badge;
import christmas.constant.Menu;
import christmas.domain.Benefit;
import christmas.domain.Order;
import christmas.domain.VisitDate;

import java.util.Map;
import java.util.stream.Collectors;

import static christmas.constant.Menu.*;
import static christmas.domain.VisitDate.*;

public class OutputView {
    private static final String START_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String RESULT_HEADLINE_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_HEADLINE = "\n<주문 메뉴>";
    private static final String MENU_LIST = "%s %d개\n";
    private static final String TOTAL_AMOUNT = "\n<할인 전 총주문 금액>\n%,d원\n";
    private static final String GIFT_AMOUNT = "\n<증정 메뉴>\n%s";
    private static final String BENEFIT_LIST = "\n<혜택 내역>\n%s";
    private static final String EACH_BENEFIT = "%s: %,d원\n";
    private static final String TOTAL_BENEFIT = "\n<총혜택 금액>\n%,d원\n";
    private static final String BENEFITED_AMOUNT = "\n<할인 후 예상 결제 금액>\n%,d원\n";
    private static final String EVENT_BADGE = "\n<12월 이벤트 배지>\n%s";
    private static final String NO_BENEFIT = "없음\n";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printResult(VisitDate date, Order order) {
        System.out.printf(RESULT_HEADLINE_MESSAGE, date.getDayNumber());
        printMenu(order);
        printOrderResult(order);
        printBenefitResult(new Benefit(date, order));
    }

    private void printMenu(Order order) {
        System.out.println(ORDER_HEADLINE);
        for (Map.Entry<Menu, Integer> entry : order.getMenuBoard().entrySet()) {
            System.out.printf(MENU_LIST, entry.getKey().getName(), entry.getValue());
        }
    }

    private void printOrderResult(Order order) {
        System.out.printf(TOTAL_AMOUNT, order.getTotalAmount());
        System.out.printf(GIFT_AMOUNT, getGiftString(order.canGetGift()));
    }

    private void printBenefitResult(Benefit benefit) {
        System.out.printf(BENEFIT_LIST, getBenefitString(benefit));
        System.out.printf(TOTAL_BENEFIT, -benefit.getTotalBenefit());
        System.out.printf(BENEFITED_AMOUNT, benefit.getBenefitedTotalAmount());
        System.out.printf(EVENT_BADGE, Badge.of(benefit.getTotalBenefit()).getName());
    }

    private String getBenefitString(Benefit benefit) {
        if (benefit.getTotalBenefit() > 0) {
            return benefit.getBenefitBoard().entrySet().stream()
                    .filter(entry -> entry.getValue() > 0)
                    .map(entry -> String.format(EACH_BENEFIT, entry.getKey().getName(), -entry.getValue()))
                    .collect(Collectors.joining());
        }
        return NO_BENEFIT;
    }

    private String getGiftString(boolean canGetGift) {
        if (canGetGift) {
            return String.format(MENU_LIST, CHAMPAGNE.getName(), 1);
        }
        return NO_BENEFIT;
    }
}
