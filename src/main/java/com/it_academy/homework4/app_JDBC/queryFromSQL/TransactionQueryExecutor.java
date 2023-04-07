package com.it_academy.homework4.app_JDBC.queryFromSQL;

import com.it_academy.homework4.app_JDBC.model.Transaction;

import java.sql.*;

import static com.it_academy.homework4.app_JDBC.scannerMain.Menu.startApp;
import static com.it_academy.homework4.app_JDBC.scannerMain.ScannerHelper.checkBalanceLimits;

public class TransactionQueryExecutor {
    public static void addNewTransaction(Connection connection, Transaction transaction) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Transactions (accountId, amount) VALUES (?,?) ;");
        preparedStatement.setInt(1, transaction.getAccountId());
        preparedStatement.setInt(2, transaction.getAmount());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void changeBalance(Connection connection, Transaction transaction) throws SQLException {
        AccountQueryExecutor queryCheckingSQL = new AccountQueryExecutor(connection);
        int balanceDB = queryCheckingSQL.getAccountBalance(transaction.getAccountId());
        int numbBalance = balanceDB + transaction.getAmount();
        if (checkBalanceLimits(numbBalance)) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE Accounts SET balance = ? WHERE accountId = ?");
            preparedStatement.setInt(1, numbBalance);
            preparedStatement.setInt(2, transaction.getAccountId());
            preparedStatement.executeUpdate();
            addNewTransaction(connection, transaction);
            preparedStatement.close();
        } else {
            System.out.println("Баланс не может быть отрицательным и/или превышать 2’000’000’000. Давайте вернемся к Навигации");
            startApp(connection);
        }
    }
}
