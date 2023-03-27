package com.it_academy.homework3.calculator;

public enum Constants {
    /*Max Length of Array is 3 */
    maxLength(3),
    firstNumb(0),
    sign(1),
    seconNub(2);


    private final int constants;

    public int getConstants() {
        return constants;
    }

    Constants(int constants) {
        this.constants = constants;
    }

    public int getcConstants() {
        return constants;
    }

}
