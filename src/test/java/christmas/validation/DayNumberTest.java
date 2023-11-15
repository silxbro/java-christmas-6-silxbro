package christmas.validation;

import christmas.constant.Error;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class DayNumberTest {
    @DisplayName("1 이상 31 이하의 숫자를 입력하면 해당 숫자를 반환")
    @Test
    void inRangeTest() {
        for (int number = 1; number <= 31; number++) {
            assertEquals(number, DayNumber.validateRange(number));
        }
    }

    @DisplayName("1 이상 31 이하가 아닌 숫자를 입력하면 알맞은 에러 메시지를 반환")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 32, 50, 100})
    void notInRangeTest(int number) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> DayNumber.validateRange(number));
        assertEquals(Error.INVALID_DATE.getMessage(), exception.getMessage());
    }
}