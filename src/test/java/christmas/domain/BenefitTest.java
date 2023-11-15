package christmas.domain;

import christmas.constant.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static christmas.constant.Discount.*;
import static christmas.constant.Menu.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BenefitTest {
    private Map<Menu, Integer> menuBoard1;
    private Map<Menu, Integer> menuBoard2;
    private Map<Menu, Integer> menuBoard3;

    @BeforeEach
    void setUp() {
        menuBoard1 = Map.of(TAPAS, 1, ZERO_COKE, 1);
        menuBoard2 = Map.of(T_BONE_STEAK, 1, SEAFOOD_PASTA, 1, CHAMPAGNE, 1);
        menuBoard3 = Arrays.stream(Menu.values()).collect(Collectors.toMap(menu -> menu, menu -> 1));
    }

    @DisplayName("getTotalBenefit 메소드 사용시 총혜택 금액 반환")
    @Nested
    class getTotalBenefit_test {
        @Test
        void case1() {
            Benefit benefit = new Benefit(new VisitDate(15), new Order(menuBoard1));
            assertEquals(0, benefit.getTotalBenefit());
        }

        @Test
        void case2() {
            Benefit benefit = new Benefit(new VisitDate(25), new Order(menuBoard2));
            assertEquals(4400, benefit.getTotalBenefit());
        }

        @Test
        void case3() {
            Benefit benefit = new Benefit(new VisitDate(31), new Order(menuBoard3));
            assertEquals(30046, benefit.getTotalBenefit());
        }

    }

    @DisplayName("getBenefitBoard 메소드 사용시 각 내역의 혜택 금액 반환")
    @Nested
    class getBenefitBoard_test {
        @Test
        void case1() {
            Benefit benefit = new Benefit(new VisitDate(9), new Order(menuBoard2));

            assertEquals(1800, benefit.getBenefitBoard().get(XMAS));
            assertEquals(0, benefit.getBenefitBoard().get(WEEKDAY));
            assertEquals(4046, benefit.getBenefitBoard().get(WEEKEND));
            assertEquals(0, benefit.getBenefitBoard().get(SPECIAL));
            assertEquals(0, benefit.getBenefitBoard().get(GIFT));
        }

        @Test
        void case2() {
            Benefit benefit = new Benefit(new VisitDate(25), new Order(menuBoard3));

            assertEquals(3400, benefit.getBenefitBoard().get(XMAS));
            assertEquals(4046, benefit.getBenefitBoard().get(WEEKDAY));
            assertEquals(0, benefit.getBenefitBoard().get(WEEKEND));
            assertEquals(1000, benefit.getBenefitBoard().get(SPECIAL));
            assertEquals(25000, benefit.getBenefitBoard().get(GIFT));
        }
    }

    @DisplayName("getBenefitedTotalAmount 메소드 사용시 할인 후 예상 결제 금액 반환")
    @Nested
    class getBenefitedTotalAmount_test {
        @Test
        void case1() {
            Benefit benefit = new Benefit(new VisitDate(7), new Order(menuBoard1));
            assertEquals(8500, benefit.getBenefitedTotalAmount());
        }

        @Test
        void case2() {
            Benefit benefit = new Benefit(new VisitDate(24), new Order(menuBoard2));
            assertEquals(110700, benefit.getBenefitedTotalAmount());
        }

        @Test
        void case3() {
            Benefit benefit = new Benefit(new VisitDate(15), new Order(menuBoard3));
            assertEquals(286008, benefit.getBenefitedTotalAmount());
        }
    }
}
