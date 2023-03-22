package com.it_academy.homework3.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorNewTest {
    private CalculatorNew calculator;
    @BeforeEach
    public void setUp () throws Exception {
        calculator = new CalculatorNew();
    };
    @Test
    public void testMultipleTwoNumbers(){
        assertEquals(calculator.multipleTwoNumbers(4,5),
                20);
        /*assertEquals("Multiplication works correctly",
                calculator.multipleTwoNumbers(4,5),
                20);

         */
        assertEquals(calculator.multipleTwoNumbers(4,5),
                20,"Multiplication works incorrectly");
    }
  /*
    private ICalculator[] array1 = {new Calculator()};

    @Test
    @Order(1)
    @DisplayName("Положительные цeлые числа")
    public void test1() {
        for (ICalculator i : array1) {
            Double str2 = i.divideTwoNumbers(90876, 3456);
            System.out.println(str2);
            Double str5 = i.multipleTwoNumbers(33, 5);
            System.out.println(str5);
            Double str6 = i.subtractionTwoNumbers(1234, 67);
            System.out.println(str6);
            Double str7 = i.sumTwoNumbers(12345677, 778999);
            System.out.println(str7);
        }
    }

    ;

    @Test
    @Order(2)
    @DisplayName("Тестирование отрицательных чисел и 0")
    public void test2() {
        for (ICalculator i : array1) {
            Double str2 = i.divideTwoNumbers(-90876, 0);
            System.out.println(str2);
            Double str5 = i.multipleTwoNumbers(11, -6788);
            System.out.println(str5);
            Double str6 = i.subtractionTwoNumbers(-567, 0);
            System.out.println(str6);
            Double str7 = i.sumTwoNumbers(-1235, 0);
            System.out.println(str7);
        }
    }

    ;

    @Test
    @Order(2)
    @DisplayName("Тестирование дробных чисел")
    public void test3() {
        for (ICalculator i : array1) {
            Double str2 = i.divideTwoNumbers(0.001234567889, 9087.09);
            System.out.println(str2);
            Double str5 = i.multipleTwoNumbers(8.4300001, -30001);
            System.out.println(str5);
            Double str6 = i.subtractionTwoNumbers(899999, 0.001234);
            System.out.println(str6);
            Double str7 = i.sumTwoNumbers(9090.00989999999, 0.000998097);
            System.out.println(str7);
        }
    }

    ;

   */
}