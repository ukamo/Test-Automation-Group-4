package com.it_academy.homework4.scanner;

import com.it_academy.homework4.model.Transaction;
import com.it_academy.homework4.query.QueryChecking;
import com.it_academy.homework4.model.Account;

import java.sql.*;
import java.util.Scanner;

public class AccountScanner {
    public static Account inputAccount(Connection connection) {
        Account account = new Account();
        Scanner scanner = new Scanner(System.in);
        QueryChecking checkAcc = new QueryChecking();
        int idFromScanner;
        while (true) {
            System.out.println("Введите Id существующего юзера: ");
            try {
                idFromScanner = Integer.parseInt(scanner.nextLine());
                if (checkAcc.isUserHasAccountId(connection, idFromScanner)) {
                    account.setUserIdFromAcc(idFromScanner);
                    break;
                } else {
                    System.out.println("Hеобходимо корректно заполнить Id существующего юзера");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введенные Вами данные некорректные. Пожалуйста, попробуйте еще раз.");
            }

        }
        while (true) {
            System.out.println("Введите баланс: ");
            try {
                account.setBalance(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Введенные Вами данные некорректные. Пожалуйста, попробуйте еще раз.");
            }
        }
        while (true) {
            System.out.println("Введите валюту: ");
            String currFromScanner = scanner.nextLine();
            boolean UserHasCurrency = checkAcc.isUserHasCurrency(connection, idFromScanner, currFromScanner);
            if (UserHasCurrency) {
                System.out.println("Этот Id уже имеет эту валюту");
            } else {
                account.setCurrency(currFromScanner);
                break;
            }
        }
        return account;
    }

    public static Transaction topUpBalanceAccount(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        Transaction transaction = new Transaction();
        QueryChecking checkAcc = new QueryChecking();
        int idFromScanner;
        int accIdChecking;
        String currencyChecking;
        while (true) {
            System.out.println("Введите Id существующего юзера: ");
            idFromScanner = Integer.parseInt(scanner.nextLine());
            if (checkAcc.isUserHasAccountId(connection, idFromScanner)) {
                //  transaction.setAccountId(idFromScanner);
                accIdChecking = idFromScanner;
                break;
            } else {
                System.out.println("Hеобходимо корректно заполнить userId существующего юзера");
            }
        }
        while (true) {
            System.out.println("Введите средства для пополнения: ");
            try {
                int amount = Integer.parseInt(scanner.nextLine());
                if (amount >= 100000000 || amount < 0) {
                    System.out.println("Введенная Вами сумма некорректная. Попробуйте еще раз.");
                } else {
                    transaction.setAmount(amount);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введенные Вами данные некорректные. Попробуйте еще раз.");
            }
        }
        while (true) {
            System.out.println("Введите валюту: ");
            String currFromScanner = scanner.nextLine();
            boolean userHasCurrency = checkAcc.isUserHasCurrency(connection, idFromScanner, currFromScanner);
            if (!userHasCurrency) {
                System.out.println("Введите существующую валюту для этого юзера:");
            } else {
                currencyChecking = currFromScanner;
                break;
            }
        }
        int accIdTransaction = checkAcc.getAccountId(connection, accIdChecking, currencyChecking);
        transaction.setAccountId(accIdTransaction);
        return transaction;
    }

    public static Transaction decreaseBalanceAccount(Connection connection) {
//    Account account = new Account();
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);
        QueryChecking checkAcc = new QueryChecking();
        int idFromScanner;
        int accIdChecking;
        String currencyChecking;
        while (true) {
            System.out.println("Введите Id существующего юзера: ");
            idFromScanner = Integer.parseInt(scanner.nextLine());
            try {
                if (checkAcc.isUserHasAccountId(connection, idFromScanner)) {
                    // transaction.setAccountId(idFromScanner);
                    accIdChecking = idFromScanner;
                    break;
                } else {
                    System.out.println("Hеобходимо корректно заполнить Id существующего юзера");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введенные Вами данные некорректные. Пожалуйста, попробуйте еще раз.");
            }
        }
        while (true) {
            System.out.println("Введите необходимую cумму для снятия: ");
            try {
                int balanceFromUser = Integer.parseInt(scanner.nextLine());
                if (balanceFromUser >= 100000000 || balanceFromUser < 0) {
                    System.out.println("Введенная Вами сумма некорректная. Пожалуйста, попробуйте еще раз.");
                } else {
                    transaction.setAmount(-balanceFromUser);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Введенные Вами данные некорректные. Пожалуйста, попробуйте еще раз.");
            }
        }
        while (true) {
            System.out.println("Введите существующую валюту: ");
            String currFromScanner = scanner.nextLine();
            boolean UserHasCurrency = checkAcc.isUserHasCurrency(connection, idFromScanner, currFromScanner);
            if (!UserHasCurrency) {
                System.out.println("Введенная Вами валюта не существует.Пожалуйста, попробуйте еще раз.");
            } else {
                currencyChecking = currFromScanner;
                break;
            }
        }
        int accIdTransaction = checkAcc.getAccountId(connection, accIdChecking, currencyChecking);
        transaction.setAccountId(accIdTransaction);
        return transaction;
    }
    public static Transaction сhangeBalanceAccount(Connection connection, boolean isBalanceIncrease) {
//    Account account = new Account();
        Transaction transaction = new Transaction();
        Scanner scanner = new Scanner(System.in);
        QueryChecking checkAcc = new QueryChecking();
        int idFromScanner;
        int accIdChecking;
        String currencyChecking;
        while (true) {
            System.out.println("Введите Id существующего юзера: ");
            idFromScanner = Integer.parseInt(scanner.nextLine());
            try {
                if (checkAcc.isUserHasAccountId(connection, idFromScanner)) {
                    // transaction.setAccountId(idFromScanner);
                    accIdChecking = idFromScanner;
                    break;
                } else {
                    System.out.println("Hеобходимо корректно заполнить Id существующего юзера");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введенные Вами данные некорректные. Пожалуйста, попробуйте еще раз.");
            }
        }
        while (true) {
            if (isBalanceIncrease){
                System.out.println("Введите средства для пополнения: ");
                try {
                    int amount = Integer.parseInt(scanner.nextLine());
                    if (amount >= 100000000 || amount < 0) {
                        System.out.println("Введенная Вами сумма некорректная. Попробуйте еще раз.");
                    } else {
                        transaction.setAmount(amount);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введенные Вами данные некорректные. Попробуйте еще раз.");
                }
            } else{
                System.out.println("Введите необходимую cумму для снятия: ");
                try {
                    int balanceFromUser = Integer.parseInt(scanner.nextLine());
                    if (balanceFromUser >= 100000000 || balanceFromUser < 0) {
                        System.out.println("Введенная Вами сумма некорректная. Пожалуйста, попробуйте еще раз.");
                    } else {
                        transaction.setAmount(-balanceFromUser);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введенные Вами данные некорректные. Пожалуйста, попробуйте еще раз.");
                }
            }

        }
        while (true) {
            System.out.println("Введите существующую валюту: ");
            String currFromScanner = scanner.nextLine();
            boolean UserHasCurrency = checkAcc.isUserHasCurrency(connection, idFromScanner, currFromScanner);
            if (!UserHasCurrency) {
                System.out.println("Введенная Вами валюта не существует.Пожалуйста, попробуйте еще раз.");
            } else {
                currencyChecking = currFromScanner;
                break;
            }
        }
        int accIdTransaction = checkAcc.getAccountId(connection, accIdChecking, currencyChecking);
        transaction.setAccountId(accIdTransaction);
        return transaction;
    }

    public static boolean checkBalanceLimits(int balance) {
        return balance > 0 && balance < 2000000000;
    }




}

