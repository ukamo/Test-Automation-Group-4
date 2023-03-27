package com.it_academy.homework3.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.it_academy.homework3.calculator.Constants.firstNumb;
import static com.it_academy.homework3.calculator.Constants.seconNub;

public class MainDivideBySpace {
    public static void main(String[] args) {
        System.out.println("Программа принимает выражения с пробелом до и после арифметического знака,например, 1 + 2");
        while (true) {
            /*
            user
            * Calcualtor c = Car()
            * double = c.calc(expression
            *
            * */
            System.out.print("Введите выражение: ");
            Scanner input = new Scanner(System.in);
            String strFromUser = input.nextLine();
            CalculatorNew calc = new CalculatorNew();
            String[] arrSplit = calc.changeStringFromArray(strFromUser);
            try {
                double number1 = calc.parseFromStringToDouble(arrSplit[firstNumb.getConstants()]);
                String sign = arrSplit[Constants.sign.getcConstants()];
                double number2 = calc.parseFromStringToDouble(arrSplit[seconNub.getConstants()]);
                double rez = calc.checkSign(sign, number1, number2);
                String rezultOfExpression = calc.viewRez(rez);
                System.out.println(rezultOfExpression);
                break;
            } catch (InputMismatchException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Данные введены неверно, попробуйте еще раз");

            } catch (ScannerException e) {
                //sout(e.getMessage());
                System.out.println("Пользователь ввел неверный знак");
            }
        }
    }
}