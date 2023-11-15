package christmas.validation;

import christmas.constant.Error;
import christmas.constant.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static christmas.constant.Menu.*;
import static org.junit.jupiter.api.Assertions.*;

public class MenuBoardTest {

    @DisplayName("정상 입력")
    @Test
    void normalCase() {
        Map<Menu, Integer> menuBoard = MenuBoard.validate("시저샐러드-2,크리스마스파스타-1,제로콜라-1");

        assertEquals(Map.of(CAESAR_SALAD, 2, CHRISTMAS_PASTA, 1, ZERO_COKE, 1), menuBoard);
    }

    @DisplayName("입력값(메뉴) 형식 오류 시 알맞은 에러 메시지 출력")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", ",크리스마스파스타-1,제로콜라-1", "크리스마스파스타1,제로콜라-1", "크리스마스파스타-1제로콜라-1"})
    void exceptionCase_1(String value) {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> MenuBoard.validate(value));
        Assertions.assertEquals(Error.INVALID_ORDER.getMessage(), exception.getMessage());
    }

    @DisplayName("메뉴 이름 오류 시 알맞은 에러 메시지 출력")
    @ParameterizedTest
    @ValueSource(strings = {"크리스마스파스타-1,크리스마스파스타-3", "크리스마스-1,제로콜라-1", "레드와인-5,제로콜라-5"})
    void exceptionCase_2(String value) {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> MenuBoard.validate(value));
        Assertions.assertEquals(Error.INVALID_ORDER.getMessage(), exception.getMessage());
    }

    @DisplayName("메뉴 개수 오류 시 알맞은 에러 메시지 출력")
    @ParameterizedTest
    @ValueSource(strings = {"크리스마스파스타-0,제로콜라-3", "크리스마스파스타--1,제로콜라-3", "크리스마스파스타-10,제로콜라-11"})
    void exceptionCase_3(String value) {

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> MenuBoard.validate(value));
        Assertions.assertEquals(Error.INVALID_ORDER.getMessage(), exception.getMessage());
    }

}
