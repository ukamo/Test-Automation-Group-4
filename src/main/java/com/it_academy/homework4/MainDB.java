package com.it_academy.homework4;

import com.it_academy.homework4.scanner.AccountScanner;
import com.it_academy.homework4.scanner.UserScanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static com.it_academy.homework4.query.QueryExecutor.*;

public class MainDB {
    private static final String SQL_URL =
            "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\main\\myResources\\DBJM.db";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        if (existDriver()) {
            connection = DriverManager.getConnection(SQL_URL);
            addBalance(connection, AccountScanner.сhangeBalanceAccount(connection, true));
            /*
            String action;
            do {
                printMenu();
                System.out.print("Введите необходимый запрос: ");
                action = new Scanner(System.in).nextLine();
                switch (action) {
                    case "1" -> addNewUser(connection, UserScanner.inputUser());
                    case "2" -> addNewAccount(connection, AccountScanner.inputAccount(connection));
                    case "3" -> addBalance(connection, AccountScanner.topUpBalanceAccount(connection));
                    case "4" -> decreaseBalance(connection, AccountScanner.decreaseBalanceAccount(connection));
                    case "5" -> showAllUsers(connection);
                    case "6" -> showAllAccounts(connection);
                }
                System.out.println("Запрос выполнен успешно");
            }
            while (!"7".equals(action));
            connection.close();

             */
        }
    }
    public static boolean existDriver()  {
        try {
            Class.forName("org.sqlite.JDBC");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("JFBC driver was Not found by the path");
            return false;
        }
    }

    private static void printMenu() {
        System.out.println("Навигация:");
        System.out.println("1 - создать нового юзера");
        System.out.println("2 - создать новый аккаунт");
        System.out.println("3 - пополнить баланс существующего аккаунта");
        System.out.println("4 - снятие средств с баланса существующего аккаунта");
        System.out.println("5 - просмотр всех юзеров с ID");
        System.out.println("6 - просмотр всех аккаунтов с ID юзера, актуальным балансом и существующей валютой ");
        System.out.println("7 - выход из программы");
    }


}
