package com.it_academy.homework3.calculator;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorNewTest {
    private CalculatorNew calculator;

    @BeforeEach
    public void setUp()  {
        calculator = new CalculatorNew();
    }

    @Test
    @DisplayName("Изменяем строку в массив")
    public void testChangeStringFromArray() {
        assertThat(calculator.changeStringFromArray("3 + 4"))
                .hasSize(3).as("Size is not 3");
        assertThat(calculator.changeStringFromArray(" 2 + 5"))
                .hasSize(3).as("Size is not 3");
        assertThat(calculator.changeStringFromArray("Test1 and Test3 "))
                .hasSize(3).as("Size is not 3");
    }

    @Test
    @DisplayName("Парсинг Строки в Double числа")
    public void testParseFromStringToDouble() {
        assertThat(calculator.parseFromStringToDouble("3")).
                as("Parsing from String to Double dos not work correctly").isEqualTo(3.00);
    }

    @Test
    @DisplayName("Проверка арифметического знака")
    public void testCheckSign() throws ScannerException {
        assertThat(calculator.checkSign("+", 3, 4)).
                as("Checking of sign, sum are not performed correctly")
                .isEqualTo(7);
        assertThat(calculator.checkSign("*", 3, 4)).
                as("Checking of sign, multiplication are not performed correctly")
                .isEqualTo(12);
        assertThat(calculator.checkSign("-", 3, 4)).
                as("Checking of sign, substraction are not performed correctly")
                .isEqualTo(-1);
        assertThat(calculator.checkSign("/", 40, 10)).
                as("Checking of sign, division are not performed correctly")
                .isEqualTo(4);
    }

    @Test
    @DisplayName("Умножение чисел")
    public void testMultiplyTwoNumbers() {
        assertThat(calculator.multiplyTwoNumbers(4.00, 5)).
                as("Multiply two positive numbers").isEqualTo(20);
        assertThat(calculator.multiplyTwoNumbers(-2.8, -2.789)).
                as("Multiplication negative decimal numbers").isEqualTo(7.8092);
        assertThat(calculator.multiplyTwoNumbers(340.5678, -6)).
                as("Multiply positive decimal and negative number").isEqualTo(-2043.4067999999997);
        assertThat(calculator.multiplyTwoNumbers(0, 57890643219.00)).
                as("Multiply 0 and positive number").isEqualTo(0.00);
        assertThat(calculator.multiplyTwoNumbers(0, -123456789.00)).
                as("Multiply negative number and 0 ").isEqualTo(0.00);
    }

    @Test
    @DisplayName("Деление чисел")
    public void testDivideTwoNumbers() {
        assertThat(calculator.divideTwoNumbers(100.00, 5)).
                as("A positive higher number is divided by a positive lower number").isEqualTo(20);
        assertThat(calculator.divideTwoNumbers(-10.305, 50)).
                as("Positive smaller decimal number is divided by a larger decimal number").isEqualTo(-0.2061);
        assertThat(calculator.divideTwoNumbers(-2346, -567)).
                as("Negative larger number is divided by a negative smaller number").isEqualTo(4.137566137566138);
        assertThat(calculator.divideTwoNumbers(-1987.352, 789564)).
                as("Negative smaller decimal number divide the negative larger number").isEqualTo(-0.0025170245857207268);
        //??
        assertEquals(Double.NaN, calculator.divideTwoNumbers(908654, 0));

        //???as("Number divide on 0")
        assertThat(calculator.divideTwoNumbers(0, -12345.6789)).
                as("0 is divided by a negative decimal number").isEqualTo(0);
    }

    @Test
    @DisplayName("Суммирование чисел")
    public void testSumTwoNumbers() {
        assertThat(calculator.sumTwoNumbers(4.00, 5)).
                as("Sum two positive numbers").isEqualTo(9);
        assertThat(calculator.sumTwoNumbers(-2.8, -2.789)).
                as("Sum negative decimal numbers").isEqualTo(-5.589);
        assertThat(calculator.sumTwoNumbers(340.5678, -6)).
                as("Sum positive decimal and negative number").isEqualTo(334.5678);
        assertThat(calculator.sumTwoNumbers(0, 57890643219.00)).
                as("Sum 0 and positive number").isEqualTo(57890643219.00);
        assertThat(calculator.sumTwoNumbers(0, -123456789.00)).
                as("Sum negative number and 0 ").isEqualTo(-123456789.00);
    }

    @Test
    @DisplayName("Вычитание чисел")
    public void testSubtractTwoNumbers() {
        assertThat(calculator.subtractTwoNumbers(100, 5)).
                as("Positive larger number minus the positive smaller number").isEqualTo(95);
        assertThat(calculator.subtractTwoNumbers(2.8, 200.01)).
                as("Positive smaller decimal number minus the larger decimal number").isEqualTo(-197.20999999999998);
        assertThat(calculator.subtractTwoNumbers(-340.5678, -6)).
                as("Negative larger number minus the negative smaller number").isEqualTo(-334.5678);
        assertThat(calculator.subtractTwoNumbers(-555, -8765.00)).
                as("Negative smaller decimal number minus the negative larger number").isEqualTo(8210.0);
        assertThat(calculator.subtractTwoNumbers(45.67, 0)).
                as("Positive decimal number minus 0").isEqualTo(45.67);
        assertThat(calculator.subtractTwoNumbers(0, 0)).
                as("0 minus 0").isEqualTo(0);
    }

    @Test
    @DisplayName("Отображение результатов - положительное число без знаков, дробное - с 3 знаками после точки")
    public void testViewRez() {
        assertThat(calculator.viewRez(100)).
                as("Number without decimal").isEqualTo("100");
        assertThat(calculator.viewRez(100.5)).
                as("Decimal number with 1 number after dot appears with 3 numbers after dot ").isEqualTo("100.500");
        assertThat(calculator.viewRez(100.506788)).
                as("Decimal number with 6 number after dot appears with 3 numbers after dot and rounded ").isEqualTo("100.507");
    }


    @Test
    @DisplayName("Тестирование исключений - другой знак арифметической операции")
    public void checkThrowsWithOtherSign() {
        Assertions.assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                calculator.checkSign("^", 1, 2);
            }
        }).isInstanceOf(ScannerException.class).as("Other signs are invalid ");
    }

    @Test
    @DisplayName("Тестирование исключений - дробное число с запятой или знаком вопроса вместо точки")
    public void testThrowsDecimalNumberWithoutDot(){
        Assertions.assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                calculator.parseFromStringToDouble("3,3 + 3?5");
            }
        }).isInstanceOf(NumberFormatException.class).as("Decimal numbers with other signs are invalid");
    }

    @Test
    @DisplayName("Тестирование исключений - размер строки (с делением на пробелы) больше 3 ")
    public void testThrowsSizeOfStringMore(){
        Assertions.assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                calculator.changeStringFromArray(" 3    + 4            ");
            }
        }).isInstanceOf(NumberFormatException.class).as("Size of String is Not 3");
    }

    @Test
    @DisplayName("Тестирование исключений - размер строки (с делением на пробелы) меньше 3 ")
    public void testThrowsSizeOfStringLess(){
        Assertions.assertThatThrownBy(new ThrowableAssert.ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                calculator.changeStringFromArray("3+4");
            }
        }).isInstanceOf(NumberFormatException.class).as("Size of String is Not 3");
    }








}