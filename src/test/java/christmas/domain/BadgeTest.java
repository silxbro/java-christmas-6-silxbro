package christmas.domain;

import christmas.constant.Badge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeTest {

    @DisplayName("총혜택 금액에 따라 알맞은 이벤트 배지 반환")
    @ParameterizedTest
    @CsvSource(value = {"20000:산타", "10000:트리", "5000:별", "0:없음"}, delimiter = ':')
    void Badge_by_total_benefit_test(int input, String expected) {
        String actualValue = Badge.of(input).getName();

        assertEquals(expected, actualValue);
    }
}