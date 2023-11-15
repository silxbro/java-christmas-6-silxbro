package christmas.domain;

import christmas.constant.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static christmas.constant.Menu.*;
import static christmas.constant.MenuCategory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    private Map<Menu, Integer> menuBoard1;
    private Map<Menu, Integer> menuBoard2;
    private Map<Menu, Integer> menuBoard3;

    @BeforeEach
    void setUp() {
        menuBoard1 = Map.of(TAPAS, 1, ZERO_COKE, 1);
        menuBoard2 = Map.of(T_BONE_STEAK, 1, SEAFOOD_PASTA, 1, CHAMPAGNE, 1);
        menuBoard3 = Arrays.stream(Menu.values()).collect(Collectors.toMap(menu -> menu, menu -> 1));
    }

    @DisplayName("getTotalAmount 메소드 사용시 총주문 금액 반환")
    @Test
    void getTotalAmount_test() {
        assertEquals(8500, new Order(menuBoard1).getTotalAmount());
        assertEquals(115000, new Order(menuBoard2).getTotalAmount());
        assertEquals(296500, new Order(menuBoard3).getTotalAmount());
    }

    @DisplayName("getCategoryCount 메소드 사용시 해당 카테고리의 메뉴 개수 반환")
    @Test
    void getCategoryCount_test() {
        assertEquals(1, new Order(menuBoard1).getCategoryCount(APPETIZER));
        assertEquals(0, new Order(menuBoard2).getCategoryCount(DESERT));
        assertEquals(4, new Order(menuBoard3).getCategoryCount(MAIN));
    }

    @DisplayName("canGetBenefit 메소드 사용시 할인 혜택 해당 여부 반환")
    @Test
    void canGetBenefit_test() {
        assertEquals(false, new Order(menuBoard1).canGetBenefit());
        assertEquals(true, new Order(menuBoard2).canGetBenefit());
        assertEquals(true, new Order(menuBoard3).canGetBenefit());
    }

    @DisplayName("canGetGift 메소드 사용시 증정 이벤트 해당 여부 반환")
    @Test
    void canGetGift_test() {
        assertEquals(false, new Order(menuBoard1).canGetGift());
        assertEquals(false, new Order(menuBoard2).canGetGift());
        assertEquals(true, new Order(menuBoard3).canGetGift());
    }
}
