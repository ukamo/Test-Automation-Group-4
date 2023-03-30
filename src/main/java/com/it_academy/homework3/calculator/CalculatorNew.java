package com.it_academy.homework3.calculator;


import java.util.Locale;

import static com.it_academy.homework3.calculator.Constants.MAX_EXPRESSION_SIZE;

public class CalculatorNew {

    public String[] changeStringFromArray(String stringFromUs) {
        String strWithoutTrim = stringFromUs.trim();
        String pattern = " ";
        String[] arrSplit = strWithoutTrim.split(pattern);
        if (arrSplit.length < MAX_EXPRESSION_SIZE || arrSplit.length > MAX_EXPRESSION_SIZE) {
            throw new NumberFormatException();
        }
        return arrSplit;
    }

    public double parseFromStringToDouble(String str) {
        return Double.parseDouble(str);
    }

    public double checkSign(String sign, double number1, double number2) {
        return switch (sign) {
            case "/" -> divideTwoNumbers(number1, number2);
            case "+" -> sumTwoNumbers(number1, number2);
            case "-" -> subtractTwoNumbers(number1, number2);
            case "*" -> multiplyTwoNumbers(number1, number2);
            default -> throw new ScannerException("Invalid sign: " + sign);
        };
    }

    public double multiplyTwoNumbers(double numberOne, double numberTwo) {
        double result = numberOne * numberTwo;
        if (result == -0.0) {
            return 0.0;
        }
        return result;
    }

    public double divideTwoNumbers(double numberOne, double numberTwo) {
        if (numberTwo != 0) {
            double result = numberOne / numberTwo;
            if (result == -0.0) {
                return 0.0;
            }
            return result;
        } else {
            System.out.println("На 0 делить нельзя");
            return Double.NaN;
        }
    }

    public double sumTwoNumbers(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    public double subtractTwoNumbers(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }

    public String formatResult(double result) {
        String resString = "";
        if (!Double.isNaN(result)) {
            if (result % 1 == 0) {
                resString = String.format(Locale.US, "%.0f", result);
            } else {
                resString = String.format(Locale.US,"%.3f", result);
            }
        }
        return resString;
    }


}
