package com.it_academy.homework3.calculator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static java.lang.Double.NaN;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

class CalculatorNewTest {
    private CalculatorNew calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorNew();
    }

    @ParameterizedTest
    //@Order(1)
    @CsvSource({"3 + 4, 3 ",
            " 2 + 5, 3",
            "Test1 and Test3 ,3 ",
    })
    @Tag("Smoke")
    @DisplayName("Изменяем строку в массив")
    public void testChangeStringFromArray(String str, int expected) {
        assertThat(calculator.changeStringFromArray(str))
                .withFailMessage("Size of string is not 3")
                .hasSize(expected);

    }

    @ParameterizedTest
    //@Order(2)
    @Tag("Smoke")
    @CsvSource({"3,3.00", "897654321.567, 897654321.567"})
    @DisplayName("Парсинг Строки в Double числа")
    public void testParseFromStringToDouble(String str, double numb) {
        assertThat(calculator.parseFromStringToDouble(str)).
                withFailMessage("Parsing from String to Double dos not work correctly").isEqualTo(numb);
    }

    @ParameterizedTest
    //@Order(3)
    @Tag("Smoke")
    @CsvSource({"+,3.00, 4.00, 7.00",
            "*,6.00, 4.00, 24.00",
            "-,33.00, 4.00, 29.00",
            "/,50.00, 10.00, 5.00"})

    @DisplayName("Проверка арифметического знака")
    public void testCheckSign(String sign, double numberOne, double numberTwo, double result) throws ScannerException {
        assertThat(calculator.checkSign(sign, numberOne, numberTwo))
                .withFailMessage("Checking of sign - multiplication is not performed correctly")
                .isEqualTo(result);
    }


    @ParameterizedTest
    @Tag("Smoke")
    //@Order(3)
    @DisplayName("Умножение чисел")
    @CsvSource({"4,5,20",
            "-2.8,-2.789,7.8092",
            "340.5678,-6,-2043.4067999999997",
            "0, 57890643219.00,0.00",
            "0, -123456789.00, 0.00"
    })
    public void testMultiplyTwoNumbers(double numberOne, double numberTwo, double expected) {
        assertThat(calculator.multiplyTwoNumbers(numberOne, numberTwo)).
                withFailMessage("Multiply two positive numbers is not performed correctly").isEqualTo(expected);
    }


    private static Stream<Arguments> testDivide() {
        return Stream.of(
                of(100.00, 5.00, 20.0, "A positive higher number is divided by a positive lower number incorrectly"),
                of(10.305, 50, 0.2061, "Positive smaller decimal number is divided by a larger decimal number incorrectly"),
                of(-2346, -567, 4.137566137566138, "Negative larger number is divided by a negative smaller number incorrectly"),
                of(-1987.352, 789564, -0.0025170245857207268, "Negative smaller decimal number divide the negative larger number incorrectly"),
                of(0, -12345.6789, 0, "0 is divided by a negative decimal number incorrectly")
        );
    }

    @ParameterizedTest
    @Tag("Smoke")
    @DisplayName("Деление чисeл")
    @MethodSource("testDivide")
    public void testDivideTwoNumbers(double numberOne, double numberTwo, double expected, String description) {
        System.out.println(numberOne);
        assertThat(calculator.divideTwoNumbers(numberOne, numberTwo))
                .withFailMessage(description)
                .isEqualTo(expected);

    }

    @ParameterizedTest
    @CsvSource({"30,0"})
    @Tag("Smoke")
    @DisplayName("Деление числа на 0")
    public void testDivideNumberOnZero(double numberOne, double numberTwo) {
        assertThat(calculator.divideTwoNumbers(numberOne, numberTwo)).withFailMessage("Positive number is divided by O incorrectly").isNaN();
    }

    @ParameterizedTest
    @Tag("Smoke")
    @CsvFileSource(resources = "/dataforSum.csv", numLinesToSkip = 1)
    @DisplayName("Суммирование чисел")
    public void testSumTwoNumbers(double numberOne, double numberTwo, double expected, String description) {
        assertThat(calculator.sumTwoNumbers(numberOne, numberTwo)).
                as(description).isEqualTo(expected);
    }

    @ParameterizedTest
    @Tag("Smoke")
    @CsvSource({"100,5,95, \"Positive larger number minus the positive smaller number is incorrectly calculated\"",
            "2.8,200.01,-197.20999999999998, \"Positive smaller decimal number minus the larger decimal number is incorrectly calculated\"",
            "-340.5678,-6,-334.5678, \"Negative larger number minus the negative smaller number is incorrectly calculated\"",
            "-555, -8765.00,8210.0,\"Negative smaller decimal number minus the negative larger number is incorrectly calculated\"",
            "45.67, 0, 45.67,\"Positive decimal number minus 0 is incorrectly calculated\"",
            "0, 0, 0,\"0 minus 0\"",
    })
    @DisplayName("Вычитание чисел")
    public void testSubtractTwoNumbers(double numberOne, double numberTwo, double expected, String description) {
        assertThat(calculator.subtractTwoNumbers(numberOne, numberTwo))
                .withFailMessage(description)
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @Tag("Smoke")
    @CsvSource({"100,100,\"Number without decimal appears with dot  \"",
            "100.5, 100.500,\"Decimal number with 1 number after dot does Not appear with 3 numbers after dot",
            "100.506788,100.507, \"Decimal number with 6 number after dot does Not appear with 3 numbers after dot and rounded "
            })
    @DisplayName("Отображение результатов - положительное число без знаков, дробное - с 3 знаками после точки")
    public void testFormatResult(double number, String result, String description) {
        assertThat(calculator.formatResult(number))
                .withFailMessage(description)
                .isEqualTo(result);
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Отображение результатов - NaN после деления на 0")
    public void testFormatResult() {
        assertThat(calculator.formatResult(NaN))
                .withFailMessage("NaN does not appear as empty string")
                .isEqualTo("");
    }


    @ParameterizedTest
    @Tag("Regression")
    @CsvSource({"^, 1,2"})
    @DisplayName("Исключения - другой знак арифметической операции")
    public void testThrowsWithOtherSign(String sign, double firstNumber, double secondNumber) {
        assertThatThrownBy(() -> calculator.checkSign(sign, firstNumber, secondNumber)).withFailMessage("Other signs" + sign + "is invalid, ScannerException throw should be")
                .isInstanceOf(ScannerException.class);
    }

    @ParameterizedTest
    @Tag("Regression")
    @ValueSource(strings = {"3,5"})
    @DisplayName("Исключения - дробное число с запятой")
    public void testThrowsDecimalNumberWithoutDot(String str) {
        assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
                    @Override
                    public void call() throws Throwable {
                        calculator.parseFromStringToDouble(str);
                    }
                }).withFailMessage("Decimal numbers with other sign is invalid, it should be ScannerException throw")
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @Tag("Regression")
    @ValueSource(strings = {" 3    + 4            "})
    @DisplayName("Исключения - размер строки (с делением на пробелы) больше 3 ")
    public void testThrowsSizeOfStringMore(String str) {
        assertThatThrownBy(() -> calculator.changeStringFromArray(str))
                .withFailMessage("Size of String is Not 3, should be throw - NumberFormatException")
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @Tag("Regression")
    @ValueSource(strings = {"3+4"})
    @DisplayName("Исключения - размер строки (с делением на пробелы) меньше 3 ")
    public void testThrowsSizeOfStringLess(String str) {
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.changeStringFromArray(str)
        );
        assertEquals(NumberFormatException.class, exception.getClass(),
                "Size of String is Not 3, should be throw - NumberFormatException");
    }

}