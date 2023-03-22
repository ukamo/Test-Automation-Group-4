package com.it_academy.homework3.calculator;

import com.it_academy.homework1.draft.ScannerException;

public class CalculatorNew implements ICalculatorNew {

    public String[] changeStringFromArray (String stringFromUs){
        String strWithoutTrim = stringFromUs.trim();
        String pattern = " ";
        String[] arrSplit = strWithoutTrim.split(pattern);
        return arrSplit;
    }

    public double parseDoubleString (String[] array, int numberOfArray){
        double rezult = 0;
        for(int i=0; i<array.length; i++ ) {
            if(numberOfArray == i) {
                rezult = Double.parseDouble(array[i]);
            }
        }
        return rezult;
    }

    public String viewRez (double rez){
        String rezString = "";
        if (!Double.isNaN(rez)) {
            if (rez % 1 == 0) {
                rezString = String.format("%.0f", rez);
                //String.format("%.5g%n", 0.912385);
                //private static DecimalFormat df2 = new DecimalFormat("#.00");
            } else {
                rezString = String.format("%.3f", rez);
                //System.out.printf("%.3f", rez);
            }

        }
        return rezString;
    }
    public String parseString (String[] array, int numberOfArray){
        String rezult = "";
        for(int i=0; i<array.length; i++ ) {
            if(numberOfArray == i) {
                rezult = array[i];
            }
        }
        return rezult;
    }

    public double checkSign(String sign, double number1, double number2) throws ScannerException {
        double rez = switch (sign) {
            case "/" -> divideTwoNumbers(number1, number2);
            case "+" -> sumTwoNumbers(number1, number2);
            case "-" -> subtractionTwoNumbers(number1, number2);
            case "*" -> multipleTwoNumbers(number1, number2);
            default -> throw new ScannerException(sign);
        };
       return rez;
    }
    public double multipleTwoNumbers(double numberOne, double numberTwo) {
        double rezMultipleTwoNumbers = numberOne * numberTwo;
        if (rezMultipleTwoNumbers == -0.0) {
            return 0.0;
        }
        return rezMultipleTwoNumbers;
    }

    public double divideTwoNumbers(double numberOne, double numberTwo) {
        if (numberTwo != 0) {
            double rezDivideTwoNumbers = numberOne / numberTwo;
            if (rezDivideTwoNumbers == -0.0) {
                return 0.0;
            }
            return rezDivideTwoNumbers;
        } else {
            System.out.println("На 0 делить нельзя");
            return Double.NaN;
        }
    }

    public double sumTwoNumbers(double numberOne, double numberTwo) {
        double rezSumTwoNumbers = numberOne + numberTwo;
        return rezSumTwoNumbers;
    }

    public double subtractionTwoNumbers(double numberOne, double numberTwo) {
        double rezSubtractionTwoNumbers = numberOne - numberTwo;
        return rezSubtractionTwoNumbers;
    }

}
