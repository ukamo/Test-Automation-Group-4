package com.it_academy.homework4.app_JDBC.scannerMain;

import com.it_academy.homework4.app_JDBC.scannerFromModel.AccountScanner;
import com.it_academy.homework4.app_JDBC.scannerFromModel.TransactionScanner;
import com.it_academy.homework4.app_JDBC.scannerFromModel.UserScanner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static com.it_academy.homework4.app_JDBC.queryFromSQL.AccountQueryExecutor.addNewAccount;
import static com.it_academy.homework4.app_JDBC.queryFromSQL.AccountQueryExecutor.showAllAccounts;
import static com.it_academy.homework4.app_JDBC.queryFromSQL.TransactionQueryExecutor.changeBalance;
import static com.it_academy.homework4.app_JDBC.queryFromSQL.UserQueryExecutor.addNewUser;
import static com.it_academy.homework4.app_JDBC.queryFromSQL.UserQueryExecutor.showAllUsers;

public class Menu {

    public static void startApp(Connection connection) throws SQLException {
        String action;
        do {
            printMenu();
            System.out.print("Введите необходимый запрос: ");
            action = new Scanner(System.in).nextLine();
            switch (action) {
                case "1" -> addNewUser(connection, UserScanner.inputUser(connection));
                case "2" -> addNewAccount(connection, AccountScanner.inputAccount(connection));
                case "3" -> changeBalance(connection, TransactionScanner.changeBalanceAccount(connection, true));
                case "4" -> changeBalance(connection, TransactionScanner.changeBalanceAccount(connection, false));
                case "5" -> showAllUsers(connection);
                case "6" -> showAllAccounts(connection);
            }
            System.out.println("Запрос выполнен успешно");
        }
        while (!"7".equals(action));
        connection.close();
    }

    public static void printMenu() {
        System.out.println("Навигация:");
        System.out.println("1 - создать нового юзера");
        System.out.println("2 - создать новый аккаунт");
        System.out.println("3 - пополнить баланс существующего аккаунта");
        System.out.println("4 - снятие средств с баланса существующего аккаунта");
        System.out.println("5 - просмотр всех юзеров с ID");
        System.out.println("6 - просмотр всех аккаунтов с ID юзера, актуальным балансом и существующей валютой ");
        System.out.println("7 - выход из программы");
    }

    public static boolean existDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("JFBC driver was Not found by the path");
            return false;
        }
    }
}
