package com.it_academy.homework4.app_JDBC.queryFromSQL;

import com.it_academy.homework4.app_JDBC.model.Account;

import java.sql.*;

public class AccountQueryExecutor {
    private final Connection connection;

    public AccountQueryExecutor(Connection connection) {
        this.connection = connection;
    }

    public static void addNewAccount(Connection connection, Account acc) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Accounts (userId, balance,currency) VALUES ( ?, ?, ?)");

        preparedStatement.setInt(1, acc.getUserIdFromAcc());
        preparedStatement.setInt(2, acc.getBalance());
        preparedStatement.setString(3, acc.getCurrency());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public int getAccountIdSql(int userIdFromScanner, String currency) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT accountId FROM Accounts WHERE userId = " + userIdFromScanner + " AND currency = '" + currency + "';";
            ResultSet resSQL = statement.executeQuery(sql);
            return resSQL.getInt("accountId");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAccountBalance(int accountId) throws SQLException {
        Statement statement = connection.createStatement();
        String sqlSElect = "SELECT balance FROM Accounts WHERE accountId = " + accountId + ";";
        ResultSet resSQL = statement.executeQuery(sqlSElect);
        return resSQL.getInt("balance");
    }

    public static void showAllAccounts(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Accounts;");
        while (resultSet.next()) {
            System.out.println("id юзера: " + resultSet.getInt("userId"));
            System.out.println("Баланс:" + resultSet.getString("balance"));
            System.out.println("Валюта: " + resultSet.getString("currency"));
            System.out.println("---");
        }
        statement.close();
        resultSet.close();
    }

}
