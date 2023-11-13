package christmas;

import christmas.constant.Menu;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static christmas.constant.Menu.*;
import static christmas.constant.MenuType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    private Order order1;
    private Order order2;
    private Order order3;

    @BeforeEach
    void setUp() {
        Map<Menu, Integer> menuBoard1;
        Map<Menu, Integer> menuBoard2;
        Map<Menu, Integer> menuBoard3;

        menuBoard1 = new HashMap<>();
        menuBoard1.put(TAPAS, 1);
        menuBoard1.put(BARBEQUE_LIB, 1);
        menuBoard1.put(CHRISTMAS_PASTA, 1);
        menuBoard1.put(CHOCOLATE_CAKE, 1);
        menuBoard1.put(ZERO_COKE, 1);
        menuBoard1.put(RED_WINE, 1);
        order1 = new Order(menuBoard1);

        menuBoard2 = new HashMap<>();
        menuBoard2.put(T_BONE_STEAK, 1);
        menuBoard2.put(SEAFOOD_PASTA, 2);
        menuBoard2.put(CHAMPAGNE, 2);
        order2 = new Order(menuBoard2);

        menuBoard3 = new HashMap<>();
        Arrays.stream(Menu.values())
                .forEach(menu -> menuBoard3.put(menu, 1));
        order3 = new Order(menuBoard3);
    }

    @DisplayName("getTotalCount 메소드 사용시 총메뉴 개수 리턴")
    @Test
    void getTotalCount_test() {
        assertEquals(order1.getTotalCount(),6);
        assertEquals(order2.getTotalCount(),5);
        assertEquals(order3.getTotalCount(),12);
    }

    @DisplayName("getMenuTypeCount 메소드 사용시 해당 메뉴타입의 개수 리턴")
    @Test
    void getMenuTypeCount_test() {
        assertEquals(order1.getMenuTypeCount(MAIN),2);
        assertEquals(order2.getMenuTypeCount(DESERT),0);
        assertEquals(order3.getMenuTypeCount(APPETIZER),3);
    }

    @DisplayName("getTotalAmount 메소드 사용시 총주문 금액 리턴")
    @Test
    void getTotalAmount_test() {
        assertEquals(order1.getTotalAmount(),162500);
        assertEquals(order2.getTotalAmount(),175000);
        assertEquals(order3.getTotalAmount(),296500);
    }
}
