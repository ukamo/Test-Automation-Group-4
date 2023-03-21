package CalculatorProject.Calculator;

public class CalculatorWithMath implements ICalculator {
    public double multipleTwoNumbers(double numberOne, double numberTwo) {
        double rezMultipleTwoNumbers = numberOne * numberTwo;
        if (rezMultipleTwoNumbers == -0.0) {
            return 0.0;
        }
        return rezMultipleTwoNumbers;
    };

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
    };

    public double sumTwoNumbers(double numberOne, double numberTwo) {
        double rezSumTwoNumbers = numberOne + numberTwo;
        return rezSumTwoNumbers;
    };

    public double subtractionTwoNumbers(double numberOne, double numberTwo) {
        double rezSubtractionTwoNumbers = numberOne - numberTwo;
        return rezSubtractionTwoNumbers;
    };

}
