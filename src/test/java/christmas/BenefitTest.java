package christmas;

import christmas.domain.Benefit;
import christmas.domain.VisitDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BenefitTest {
    private Benefit benefit;
    Map<String, Integer> freqInput;
    @BeforeEach
    void setUp() {
        benefit = new Benefit();

        freqInput= new HashMap<>();
        freqInput.put("APPETIZER", 2);
        freqInput.put("MAIN", 3);
        freqInput.put("DESERT", 4);
        freqInput.put("DRINK", 1);
    }

    @DisplayName("주문 메뉴 및 방문 날짜에 따라 총할인 금액을 알맞게 반환한다.")
    @Test
    void testGetTotalDiscount1() {
        int actualValue = benefit.getTotalDiscount(new VisitDate(3), freqInput);
        assertThat(actualValue).isEqualTo(10292);
    }
    @DisplayName("주문 메뉴 및 방문 날짜에 따라 총할인 금액을 알맞게 반환한다.")
    @Test
    void testGetTotalDiscount2() {
        int actualValue = benefit.getTotalDiscount(new VisitDate(9), freqInput);
        assertThat(actualValue).isEqualTo(7869);
    }
    @DisplayName("주문 메뉴 및 방문 날짜에 따라 총할인 금액을 알맞게 반환한다.")
    @Test
    void testGetTotalDiscount3() {
        int actualValue = benefit.getTotalDiscount(new VisitDate(14), freqInput);
        assertThat(actualValue).isEqualTo(10392);
    }
    @DisplayName("주문 메뉴 및 방문 날짜에 따라 총할인 금액을 알맞게 반환한다.")
    @Test
    void testGetTotalDiscount4() {
        int actualValue = benefit.getTotalDiscount(new VisitDate(25), freqInput);
        assertThat(actualValue).isEqualTo(12492);
    }
}
