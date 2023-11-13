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

import static christmas.constant.DayType.*;
import static christmas.constant.Menu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BenefitTest {
    private Map<Menu, Integer> menuBoard1;
    private Map<Menu, Integer> menuBoard2;

    @BeforeEach
    void setUp() {
        menuBoard1 = new HashMap<>();
        menuBoard2 = new HashMap<>();

        menuBoard1.put(T_BONE_STEAK, 1);
        menuBoard1.put(SEAFOOD_PASTA, 2);
        menuBoard1.put(CHAMPAGNE, 2);

        Arrays.stream(Menu.values())
                .forEach(menu -> menuBoard2.put(menu, 1));
    }

    @DisplayName("getTotalDiscount 메소드 사용시 총할인 금액 리턴")
    @Test
    void getTotalDiscount_test() {
        assertEquals(new Benefit().getTotalDiscount(new VisitDate(5), new Order(menuBoard1)), 1400);
        assertEquals(new Benefit().getTotalDiscount(new VisitDate(9), new Order(menuBoard1)), 7869);
        assertEquals(new Benefit().getTotalDiscount(new VisitDate(17), new Order(menuBoard2)), 7646);
        assertEquals(new Benefit().getTotalDiscount(new VisitDate(22), new Order(menuBoard2)), 11192);
        assertEquals(new Benefit().getTotalDiscount(new VisitDate(25), new Order(menuBoard2)), 8446);
    }

    @DisplayName("getDdayXmasDiscount 메소드 사용시 크리스마스 디데이 할인 금액 리턴")
    @ParameterizedTest
    @CsvSource(value = {"1:1000", "11:2000", "25:3400"}, delimiter = ':')
    void getDdayXmasDiscount_test(int input, int expected) {
        int actualValue = new Benefit().getDdayXmasDiscount(input);
        assertEquals(expected, actualValue);
    }

    @DisplayName("getDayTypeDiscount 메소드 사용시 요일(평일/주말) 할인 금액 리턴")
    @Test
    void getDayTypeDiscount_test() {
        assertEquals(new Benefit().getDayTypeDiscount(WEEKDAY, new Order(menuBoard1)), 0);
        assertEquals(new Benefit().getDayTypeDiscount(WEEKEND, new Order(menuBoard1)), 6069);
        assertEquals(new Benefit().getDayTypeDiscount(WEEKDAY, new Order(menuBoard2)), 4046);
        assertEquals(new Benefit().getDayTypeDiscount(WEEKEND, new Order(menuBoard2)), 8092);
    }

    @DisplayName("getSpecialDiscount 메소드 사용시 특별 할인 금액 리턴")
    @ParameterizedTest
    @CsvSource(value = {"true:1000", "false:0"}, delimiter = ':')
    void getSpecialDiscount_test(boolean input, int expected) {
        int actualValue = new Benefit().getSpecialDiscount(input);
        assertEquals(expected, actualValue);
    }
}
