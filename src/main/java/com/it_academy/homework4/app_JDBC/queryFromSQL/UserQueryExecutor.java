package com.it_academy.homework4.app_JDBC.queryFromSQL;

import com.it_academy.homework4.app_JDBC.model.User;

import java.sql.*;

public class UserQueryExecutor {
    private final Connection connection;

    public UserQueryExecutor(Connection connection) {
        this.connection = connection;
    }

    public boolean isUserHasUserId(int idFromScanner) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Users WHERE userId = " + idFromScanner + ";";
            ResultSet resSQL = statement.executeQuery(sql);
            int result = resSQL.getInt("userId");
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean isUserHasCurrency(int idFromUser, String currFromScanner) {
        try {
            Statement statement = connection.createStatement();
            String sqlCurrency2 = "SELECT COUNT(*) FROM Accounts WHERE userId = " + idFromUser + " AND currency = '" + currFromScanner + "';";
            ResultSet resSQL = statement.executeQuery(sqlCurrency2);
            int result = resSQL.getInt("COUNT(*)");
            statement.close();
            return result > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public static void addNewUser(Connection connection, User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Users ( name, address) VALUES ( ?, ?)");

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getAddress());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public static void showAllUsers(Connection connection) throws SQLException {
        Statement statement = null;
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
    }


}
