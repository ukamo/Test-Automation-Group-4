package homework_1.api;

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
            //String pattern = "[*/+-]";
            String[] arrSplit = strWithoutTrim.split(pattern);
           /*for (int i=0;i<arrSplit.length;i++){
               if (arrSplit[i].equals("+") || arrSplit[i].equals("-") || arrSplit[i].equals("/")  || arrSplit[i].equals("*")){
                   sign = arrSplit[i];
               }
           }
           */
            CalculatorWithMath calcCopy = new CalculatorWithMath();
            try {
                double number1 = Double.parseDouble(arrSplit[0]);
                sign = arrSplit[1];
                double number2 = Double.parseDouble(arrSplit[2]);
                Double rez;
                switch (sign) {
                    case "/":
                        rez = calcCopy.divideTwoNumbers(number1, number2);
                        break;
                    case "+":
                        rez = calcCopy.sumTwoNumbers(number1, number2);
                        break;
                    case "-":
                        rez = calcCopy.subtractionTwoNumbers(number1, number2);
                        break;
                    case "*":
                        rez = calcCopy.multipleTwoNumbers(number1, number2);
                        break;
                    default:
                        throw new ScannerException(sign);
                        //throw new IllegalStateException("Неверный знак " + sign);
                }
                if (!Double.isNaN(rez)) {
                    System.out.println(rez);
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