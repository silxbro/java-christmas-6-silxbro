package christmas;

import christmas.constant.DayType;
import christmas.domain.VisitDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class VisitDateTest {
    private VisitDate visitDate;

    @DisplayName("getDay 메소드 사용시 해당 날짜의 day 반환")
    @ParameterizedTest
    @CsvSource(value = {"3:3", "10:10", "17:17", "25:25", "31:31"}, delimiter = ':')
    void getDay_test(int input, int expected) {
        visitDate = new VisitDate(input);
        int actualValue = visitDate.getDay();
        assertEquals(expected, actualValue);
    }

    @DisplayName("getDayType 메소드 사용시 해당 날짜의 DayType 반환")
    @ParameterizedTest
    @CsvSource(value = {"8:WEEKEND", "12:WEEKDAY", "16:WEEKEND", "20:WEEKDAY", "25:WEEKDAY"}, delimiter = ':')
    void getDayType_test(int input, DayType expected) {
        visitDate = new VisitDate(input);
        DayType actualValue = visitDate.getDayType();
        assertEquals(expected, actualValue);
    }

    @DisplayName("hasStar 메소드 사용시 해당 날짜의 별유무 반환")
    @ParameterizedTest
    @CsvSource(value = {"5:false", "10:true", "15:false", "25:true", "30:false"}, delimiter = ':')
    void hasStar_test(int input, boolean expected) {
        visitDate = new VisitDate(input);
        boolean actualValue = visitDate.hasStar();
        assertEquals(expected, actualValue);
    }
}
