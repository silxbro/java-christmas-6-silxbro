package christmas;

import christmas.constant.Menu;
import christmas.domain.Benefit;
import christmas.domain.Order;
import christmas.domain.VisitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static christmas.constant.Menu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BenefitTest {
    private Map<Menu, Integer> menuBoard1;
    private Map<Menu, Integer> menuBoard2;
    private Map<Menu, Integer> menuBoard3;

    @BeforeEach
    void setUp() {
        menuBoard1 = new HashMap<>();
        menuBoard2 = new HashMap<>();
        menuBoard3 = new HashMap<>();

        menuBoard1.put(T_BONE_STEAK, 1);
        menuBoard1.put(SEAFOOD_PASTA, 1);
        menuBoard1.put(CHAMPAGNE, 1);

        Arrays.stream(Menu.values())
                .forEach(menu -> menuBoard2.put(menu, 1));

        menuBoard3.put(CAESAR_SALAD, 1);
    }

    @DisplayName("getTotalBenefit 메소드 사용시 총혜택 금액 리턴")
    @Test
    void getTotalBenefit_test() {
        assertEquals(new Benefit().getTotalBenefit(new VisitDate(3), new Order(menuBoard1)), 2200);
        assertEquals(new Benefit().getTotalBenefit(new VisitDate(5), new Order(menuBoard1)), 1400);
        assertEquals(new Benefit().getTotalBenefit(new VisitDate(9), new Order(menuBoard1)), 5846);
        assertEquals(new Benefit().getTotalBenefit(new VisitDate(12), new Order(menuBoard2)), 31146);
        assertEquals(new Benefit().getTotalBenefit(new VisitDate(15), new Order(menuBoard2)), 35492);
        assertEquals(new Benefit().getTotalBenefit(new VisitDate(17), new Order(menuBoard2)), 32646);
        assertEquals(new Benefit().getTotalBenefit(new VisitDate(22), new Order(menuBoard3)), 0);
        assertEquals(new Benefit().getTotalBenefit(new VisitDate(25), new Order(menuBoard2)), 33446);
        assertEquals(new Benefit().getTotalBenefit(new VisitDate(28), new Order(menuBoard1)), 0);
        assertEquals(new Benefit().getTotalBenefit(new VisitDate(31), new Order(menuBoard2)), 30046);
    }

    @DisplayName("getDdayXmasDiscount 메소드 사용시 크리스마스 디데이 할인 금액 리턴")
    @ParameterizedTest
    @CsvSource(value = {"1:1000", "11:2000", "25:3400", "29:0"}, delimiter = ':')
    void getDdayXmasDiscount_test(int input, int expected) {
        int actualValue = new Benefit().getDdayXmasDiscount(new VisitDate(input));
        assertEquals(expected, actualValue);
    }

    @DisplayName("getWeekdayDiscount 메소드 사용시 평일 할인 금액 리턴")
    @Test
    void getWeekdayDiscount_test() {
        assertEquals(new Benefit().getWeekdayDiscount(true, new Order(menuBoard1)), 0);
        assertEquals(new Benefit().getWeekdayDiscount(false, new Order(menuBoard1)), 0);
        assertEquals(new Benefit().getWeekdayDiscount(true, new Order(menuBoard2)), 0);
        assertEquals(new Benefit().getWeekdayDiscount(false, new Order(menuBoard2)), 4046);
    }

    @DisplayName("getWeekendDiscount 메소드 사용시 주말 할인 금액 리턴")
    @Test
    void getWeekendDiscount_test() {
        assertEquals(new Benefit().getWeekendDiscount(true, new Order(menuBoard1)), 4046);
        assertEquals(new Benefit().getWeekendDiscount(false, new Order(menuBoard1)), 0);
        assertEquals(new Benefit().getWeekendDiscount(true, new Order(menuBoard2)), 8092);
        assertEquals(new Benefit().getWeekendDiscount(false, new Order(menuBoard2)), 0);
    }

    @DisplayName("getSpecialDiscount 메소드 사용시 특별 할인 금액 리턴")
    @ParameterizedTest
    @CsvSource(value = {"true:1000", "false:0"}, delimiter = ':')
    void getSpecialDiscount_test(boolean input, int expected) {
        int actualValue = new Benefit().getSpecialDiscount(input);
        assertEquals(expected, actualValue);
    }

    @DisplayName("getGiftAmount 메소드 사용시 증정 혜택 (증정품 가격) 금액 리턴")
    @ParameterizedTest
    @CsvSource(value = {"true:25000", "false:0"}, delimiter = ':')
    void getGiftAmount_test(boolean input, int expected) {
        int actualValue = new Benefit().getGiftAmount(input);
        assertEquals(expected, actualValue);
    }

}
