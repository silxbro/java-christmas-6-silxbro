package christmas;

import christmas.domain.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class VisitDateTest {

    @DisplayName("of 메소드 사용시 해당 VisitDate 상수 반환")
    @ParameterizedTest
    @CsvSource(value = {"3:DAY_3", "10:DAY_10", "17:DAY_17", "25:CHRISTMAS", "31:DAY_31"}, delimiter = ':')
    void of_test(int input, VisitDate expected) {
        VisitDate actualValue = VisitDate.of(input);
        assertEquals(expected, actualValue);
    }

    @DisplayName("isAfterXmas 메소드 사용시 크리스마스 이후 날짜 여부 반환")
    @ParameterizedTest
    @CsvSource(value = {"10:false", "25:false", "27:true", "31:true"}, delimiter = ':')
    void isAfterXmas_test(int input, boolean expected) {
        VisitDate visitDate = VisitDate.of(input);
        boolean actualValue = visitDate.isAfterXmas();
        assertEquals(expected, actualValue);
    }

    @DisplayName("getDaysSinceDecember1st 메소드 사용시 12월1일 과의 일수 차이 반환")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "10:9", "20:19", "25:24", "30:29"}, delimiter = ':')
    void getDaysSinceDecember1st_test(int input, int expected) {
        VisitDate visitDate = VisitDate.of(input);
        int actualValue = visitDate.getDaysSinceDecember1st();
        assertEquals(expected, actualValue);
    }

    @DisplayName("isWeekend 메소드 사용시 주말 여부 반환")
    @ParameterizedTest
    @CsvSource(value = {"8:true", "12:false", "16:true", "20:false", "25:false"}, delimiter = ':')
    void isWeekend_test(int input, boolean expected) {
        VisitDate visitDate = VisitDate.of(input);
        boolean actualValue = visitDate.isWeekend();
        assertEquals(expected, actualValue);
    }

    @DisplayName("hasStar 메소드 사용시 해당 날짜의 별유무 반환")
    @ParameterizedTest
    @CsvSource(value = {"5:false", "10:true", "15:false", "25:true", "30:false"}, delimiter = ':')
    void hasStar_test(int input, boolean expected) {
        VisitDate visitDate = VisitDate.of(input);
        boolean actualValue = visitDate.hasStar();
        assertEquals(expected, actualValue);
    }
}
