package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @DisplayName("메소드로 주어진 값을 구분")
    @Test
    void split_메소드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("메소드 사용시 구분자가 포함되지 않은 경우 값을 그대로 반환")
    @Test
    void split_메소드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @DisplayName("substring 메서드로 특정 구간 값을 반환")
    @Test
    void substring_메소드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt 메서드로 특정 위치의 문자 찾기")
    @Test
    void charAt_메소드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char result = input.charAt(0);

        assertThat(result).isEqualTo('a');
    }

    @DisplayName("charAt 메서드 사용시 문자열의 길이보다 큰 숫자 위치의 문자를 찾을 때 예외 발생")
    @Test
    void charAt_메소드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생_1() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @DisplayName("charAt 메서드 사용시 문자열의 길이보다 큰 숫자 위치의 문자를 찾을 때 예외 발생")
    @Test
    void charAt_메소드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생_2() {
        String input = "abc";

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> input.charAt(5))
                .withMessageContaining("String index out of range: 5");
    }
}
