package com.it_academy.homework3.calculator;

import com.it_academy.homework1.draft.ScannerException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_DivideBySpace {
    public static void main(String[] args) {
        System.out.println("Программа принимает выражения с пробелом до и после арифметического знака,например, 1 + 2");
        while (true) {
            System.out.print("Введите выражение: ");
            Scanner input = new Scanner(System.in);
            String strFromUser = input.nextLine();
            CalculatorNew calc = new CalculatorNew();
            String[] arrSplit = calc.changeStringFromArray(strFromUser);
            try {
                if (arrSplit.length > 3) {
                    throw new NumberFormatException();
                }
                double number1 = calc.parseDoubleString(arrSplit, 0);
                String sign = calc.parseString(arrSplit, 1);
                double number2 = calc.parseDoubleString(arrSplit, 2);
                double rez = calc.checkSign(sign, number1, number2);
                String rezultOfExpression = calc.viewRez(rez);
                System.out.println(rezultOfExpression);
                break;
            } catch (InputMismatchException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Данные введены неверно, попробуйте еще раз");

            } catch (ScannerException e) {
                System.out.println("Пользователь ввел неверный знак");
            }
        }
    }
}