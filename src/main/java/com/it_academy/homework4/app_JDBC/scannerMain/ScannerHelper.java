package com.it_academy.homework4.app_JDBC.scannerMain;
import com.it_academy.homework4.app_JDBC.queryFromSQL.UserQueryExecutor;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ScannerHelper {
    private UserQueryExecutor checkUser;

    public ScannerHelper(Connection connection) {
        this.checkUser = new UserQueryExecutor(connection);
    }
    public String scanNewUser(){
        while (true) {
            System.out.println("Введите имя юзера: ");
            String nextLine = new Scanner(System.in).nextLine();
            if (!Objects.equals(nextLine, "")) {
               return nextLine;
            } else {
                System.out.println("Hеобходимо заполнить поле Имя");
            }
        }
    }

    public int scanUserId() {
        while (true) {
            System.out.println("Введите Id существующего юзера: ");

            try {
                Scanner input = new Scanner(System.in);
                int idFromScanner = input.nextInt();
               if (checkUser.isUserHasUserId(idFromScanner)) {
                    return idFromScanner;
                } else {
                    System.out.println("Hеобходимо корректно заполнить Id существующего юзера");
                }
            } catch (InputMismatchException input) {
                System.out.println("Введенные Вами данные некорректные. Пожалуйста, попробуйте еще раз.");
            }

        }
    }
    public int scanBalance() {
        while (true) {
            System.out.println("Введите cумму: ");
            try {
                int amount = new Scanner(System.in).nextInt();
                if (amount < 0 || amount >= 100000000  ) {
                    System.out.println("Введенная Вами сумма некорректная. Попробуйте еще раз.");
                } else {
                    return amount;
                }
            } catch (InputMismatchException input) {
                System.out.println("Введенные Вами данные некорректные. Пожалуйста, попробуйте еще раз.");
            }
        }
    }
    public String scanNewCurrency(int userId) {
        while (true) {
            System.out.println("Введите валюту: ");
            String currFromScanner = new Scanner(System.in).nextLine();
            boolean UserHasCurrency = checkUser.isUserHasCurrency(userId, currFromScanner);
            if (UserHasCurrency) {
                System.out.println("Этот Id уже имеет эту валюту");
            } else {
                return currFromScanner;
            }
        }
    }
    public String scanExistCurrency(int userId) {
        while (true) {
            System.out.println("Введите валюту: ");
            String currFromScanner = new Scanner(System.in).nextLine();
            boolean UserHasCurrency = checkUser.isUserHasCurrency(userId, currFromScanner);
            if (!UserHasCurrency) {
                System.out.println("Введенная Вами валюта не существует.Пожалуйста, попробуйте еще раз.");
            } else {
                return currFromScanner;
            }
        }
    }
    public static boolean checkBalanceLimits(int balance) {
        return balance >= 0 && balance < 2000000000;
    }
}
