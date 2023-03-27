package com.it_academy.homework3.calculator;


import static com.it_academy.homework3.calculator.Constants.maxLength;

public class CalculatorNew {
    public String[] changeStringFromArray (String stringFromUs){
        String strWithoutTrim = stringFromUs.trim();
        String pattern = " ";
        String[] arrSplit = strWithoutTrim.split(pattern);
        if (arrSplit.length<maxLength.getConstants()|
                arrSplit.length > maxLength.getConstants()){
            throw new NumberFormatException();
        }
        return arrSplit;
    }

    public double parseFromStringToDouble(String str){
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
    public String viewRez (double rez){
        String resString = "";
        if (!Double.isNaN(rez)) {
            if (rez % 1 == 0) {
                resString = String.format("%.0f", rez);
            } else {
                resString = String.format("%.3f", rez);
            }
        }
        return resString;
    }

}
