package homework_1.api;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainNumberThenSign {
    public static void main(String[] args) {
        CalculatorWithMath calcCopy = new CalculatorWithMath();
        while (true) {
            try {
                System.out.print("Введите целое число 1: ");
                Scanner input = new Scanner(System.in);
                double number1 = input.nextDouble();
                System.out.print("Введите целое число 2: ");
                double number2 = input.nextDouble();
                System.out.print("Введите знак ");
                String sign = input.next();
                switch (sign) {
                    case "/":
                        double rez1 = calcCopy.divideTwoNumbers(number1, number2);
                        System.out.println(rez1);
                        break;
                    case "+":
                        double rez2 = calcCopy.sumTwoNumbers(number1, number2);
                        System.out.println(rez2);
                        break;
                    case "-":
                        double rez3 = calcCopy.subtractionTwoNumbers(number1, number2);
                        System.out.println(rez3);
                        break;
                    case "*":
                        double rez4 = calcCopy.multipleTwoNumbers(number1, number2);
                        System.out.println(rez4);
                        break;
                    default:
                        throw new ScannerException(sign);
                        //throw new IllegalStateException("Неверный знак " + sign);
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("данные введены неверно");

            } catch (ScannerException e) {
                System.out.println("Пользователь ввел неверный знак");
            }
        }
    }
}
