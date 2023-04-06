package com.it_academy.homework4.query;

import java.sql.*;

import com.it_academy.homework4.model.Transaction;
import com.it_academy.homework4.scanner.AccountScanner;
import com.it_academy.homework4.model.Account;
import com.it_academy.homework4.model.User;

import static com.it_academy.homework4.scanner.AccountScanner.checkBalanceLimits;

public class QueryExecutor {
    public static void addNewUser(Connection connection, User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Users ( name, address) VALUES ( ?, ?)");

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addNewAccount(Connection connection, Account acc) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Accounts (userId, balance,currency) VALUES ( ?, ?, ?)");

            preparedStatement.setInt(1, acc.getUserIdFromAcc());
            preparedStatement.setInt(2, acc.getBalance());
            preparedStatement.setString(3, acc.getCurrency());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void changeBalance(Connection connection, Transaction transaction) {
        try {
//            String sqlSElect = "SELECT balance FROM Accounts WHERE accountId = " + transaction.getAccountId() + ";";
//            PreparedStatement statement = connection.prepareStatement(sqlSElect);
//            ResultSet resSQL = statement.executeQuery(sqlSElect);
//            int balanceDB = resSQL.getInt("balance");

            QueryChecking queryChecking= new QueryChecking();

            int balanceDB = queryChecking.getAccountBalance(connection, transaction.getAccountId());
            int numbBalance = balanceDB + transaction.getAmount();
            if (checkBalanceLimits(numbBalance)){

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE Accounts SET balance = ? WHERE accountId = ?");
                preparedStatement.setInt(1, numbBalance);
                preparedStatement.setInt(2, transaction.getAccountId());
                preparedStatement.executeUpdate();
                addNewTransaction(connection, transaction);
                preparedStatement.close();
            } else {
                System.out.println("Баланс не может быть отрицательным и/или превышать 2’000’000’000. Попробуйте данный запрос еще раз.");
                AccountScanner.topUpBalanceAccount(connection);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addBalance(Connection connection, Transaction transaction) {
        changeBalance(connection, transaction);
    }
    public static void decreaseBalance (Connection connection, Transaction transaction){
        changeBalance(connection, transaction);

//        try {
//            Statement statement = connection.createStatement();
//            String sqlSElect = "SELECT balance FROM Accounts WHERE userId = " + account.getUserIdFromAcc() + " AND currency = '" + account.getCurrency() + "';";
//            ResultSet resSQL = statement.executeQuery(sqlSElect);
//            int balanceDB = resSQL.getInt("balance");
//            PreparedStatement preparedStatement = connection.prepareStatement(
//                    "UPDATE Accounts SET balance = ? WHERE userId = ? AND currency = ?");
//            int numbBalance = balanceDB - account.getBalance();
//            boolean resultBalance = checkBalanceLimits(numbBalance);
//            if (resultBalance){
//                System.out.println("Баланс не может быть отрицательным и/или превышать 2’000’000’000. Попробуйте данный запрос еще раз.");
//                AccountScanner.topUpBalanceAccount(connection);
//            } else {
//                preparedStatement.setInt(1, numbBalance);
//                preparedStatement.setInt(2, account.getUserIdFromAcc());
//                preparedStatement.setString(3, account.getCurrency());
//                preparedStatement.executeUpdate();
//                addNewTransaction(connection, account);
//                preparedStatement.close();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }
    public static void showAllUsers(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users;");
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("userId"));
                System.out.println("Имя:" + resultSet.getString("name"));
                System.out.println("Адрес: " + resultSet.getString("address"));
                System.out.println("---");
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Возникли проблемы с подключением к базе данных");
            throw new RuntimeException(e);
        }

    }
    public static void showAllAccounts(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Accounts;");
            while (resultSet.next()) {
                System.out.println("id юзера: " + resultSet.getInt("userId"));
                System.out.println("Баланс:" + resultSet.getString("balance"));
                System.out.println("Валюта: " + resultSet.getString("currency"));
                System.out.println("---");
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Возникли проблемы с подключением к базе данных");
            throw new RuntimeException(e);
        }

    }
    public static void addNewTransaction(Connection connection, Transaction transaction) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Transactions (accountId, amount) VALUES (?,?) ;");
            preparedStatement.setInt(1, transaction.getAccountId());
            preparedStatement.setInt(2, transaction.getAmount());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
