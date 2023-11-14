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
import static christmas.constant.MenuCategory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {
    private Map<Menu, Integer> menuBoard1;
    private Map<Menu, Integer> menuBoard2;
    private Map<Menu, Integer> menuBoard3;

    @BeforeEach
    void setUp() {
        menuBoard1 = new HashMap<>();
        menuBoard1.put(TAPAS, 1);
        menuBoard1.put(BARBEQUE_LIB, 1);
        menuBoard1.put(CHRISTMAS_PASTA, 1);
        menuBoard1.put(CHOCOLATE_CAKE, 1);
        menuBoard1.put(ZERO_COKE, 1);
        menuBoard1.put(RED_WINE, 1);

        menuBoard2 = new HashMap<>();
        menuBoard2.put(T_BONE_STEAK, 1);
        menuBoard2.put(SEAFOOD_PASTA, 2);
        menuBoard2.put(CHAMPAGNE, 2);

        menuBoard3 = new HashMap<>();
        Arrays.stream(Menu.values())
                .forEach(menu -> menuBoard3.put(menu, 1));
    }

    @DisplayName("getTotalCount 메소드 사용시 총메뉴 개수 리턴")
    @Test
    void getTotalCount_test() {
        assertEquals(new Order(menuBoard1).getTotalCount(),6);
        assertEquals(new Order(menuBoard2).getTotalCount(),5);
        assertEquals(new Order(menuBoard3).getTotalCount(),12);
    }

    @DisplayName("getMenuTypeCount 메소드 사용시 해당 메뉴타입의 개수 리턴")
    @Test
    void getMenuTypeCount_test() {
        assertEquals(new Order(menuBoard1).getMenuTypeCount(MAIN),2);
        assertEquals(new Order(menuBoard2).getMenuTypeCount(DESERT),0);
        assertEquals(new Order(menuBoard3).getMenuTypeCount(APPETIZER),3);
    }

    @DisplayName("getTotalAmount 메소드 사용시 총주문 금액 리턴")
    @Test
    void getTotalAmount_test() {
        assertEquals(new Order(menuBoard1).getTotalAmount(),162500);
        assertEquals(new Order(menuBoard2).getTotalAmount(),175000);
        assertEquals(new Order(menuBoard3).getTotalAmount(),296500);
    }
}
