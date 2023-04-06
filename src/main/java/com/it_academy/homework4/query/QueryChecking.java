package com.it_academy.homework4.query;

import com.it_academy.homework4.model.Account;

import java.sql.*;

public class QueryChecking {
    public boolean isUserHasAccountId(Connection connection,int idFromScanner) {
        Statement statement = null;
            try {
                statement = connection.createStatement();
               String sql = "SELECT * FROM Users WHERE userId = " + idFromScanner + ";";
               ResultSet resSQL = statement.executeQuery(sql);
                int result = resSQL.getInt("userId");
                return result > 0;
            } catch (SQLException e) {
                return false;
        }
    }
    public boolean isUserHasCurrency(Connection connection,int idFromUser, String currFromScanner) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sqlCurrency2 = "SELECT COUNT(*) FROM Accounts WHERE userId = " + idFromUser + " AND currency = '" + currFromScanner+"';";
            ResultSet resSQL = statement.executeQuery(sqlCurrency2);
            int result = resSQL.getInt("COUNT(*)");
            statement.close();
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public int getAccountId(Connection connection,int accIdFromScanner, String currency) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "SELECT accountId FROM Accounts WHERE userId = " + accIdFromScanner +  " AND currency = '"+ currency + "';";
            ResultSet resSQL = statement.executeQuery(sql);
            return resSQL.getInt("accountId");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getAccountBalance(Connection connection, int accountId){
        try {
            Statement statement = connection.createStatement();
            String sqlSElect = "SELECT balance FROM Accounts WHERE accountId = " + accountId + ";";
            ResultSet resSQL = statement.executeQuery(sqlSElect);
            return resSQL.getInt("balance");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
