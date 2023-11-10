package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;
    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("size 메소드 사용시 Set의 크기를 반환")
    @Test
    void size_메소드_사용시_Set의_크기를_반환() {
        int result = numbers.size();

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("contains 메소드 사용시 해당 원소가 존재함을 반환")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains_메소드_사용시_해당_원소가_존재함을_반환(int number) {
        assertTrue(numbers.contains(number));
    }

    @DisplayName("contains 메소드 사용시 해당 원소가 존재할 경우 존재, 존재하지 않을 경우 존재하지 않음을 반환")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_메소드_사용시_해당_원소의_존재_여부에_따른_결과를_반환(int input, boolean expected) {
        boolean actualValue = numbers.contains(input);
        assertEquals(expected, actualValue);
    }
}
