package CalculatorProject.Calculator;

import CalculatorProject.draft.ScannerException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainBySpace {
    public static void main(String[] args) {
        while (true) {
            System.out.print("Введите выражение: ");
            Scanner input = new Scanner(System.in);
            String strFromUser = input.nextLine();
            String strWithoutTrim = strFromUser.trim();
            String pattern = " ";
            String sign;
            String[] arrSplit = strWithoutTrim.split(pattern);
            CalculatorWithMath calcCopy = new CalculatorWithMath();
            try {
                if (arrSplit.length > 3){
                    throw new NumberFormatException();
                }
                double number1 = Double.parseDouble(arrSplit[0]);
                sign = arrSplit[1];
                double number2 = Double.parseDouble(arrSplit[2]);
                double rez = switch (sign) {
                    case "/" -> calcCopy.divideTwoNumbers(number1, number2);
                    case "+" -> calcCopy.sumTwoNumbers(number1, number2);
                    case "-" -> calcCopy.subtractionTwoNumbers(number1, number2);
                    case "*" -> calcCopy.multipleTwoNumbers(number1, number2);
                    default -> throw new ScannerException(sign);
                };
                if (!Double.isNaN(rez)) {
                    if (rez % 1 ==0){
                        System.out.printf("%.0f", rez);
                    } else {
                        System.out.printf("%.3f", rez);
                    }
                }
                break;
            } catch (InputMismatchException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Данные введены неверно, попробуйте еще раз");

            } catch (ScannerException e) {
                System.out.println("Пользователь ввел неверный знак");
            }
        }


    }
}