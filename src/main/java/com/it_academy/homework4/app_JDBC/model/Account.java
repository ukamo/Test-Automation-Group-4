package com.it_academy.homework4.app_JDBC.model;

public class Account {
    private int userIdFromAcc;
    private int balance;
    private String currency;

    public int getUserIdFromAcc() {
        return userIdFromAcc;
    }

    public void setUserIdFromAcc(int userIdFromAcc) {
        this.userIdFromAcc = userIdFromAcc;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


}
