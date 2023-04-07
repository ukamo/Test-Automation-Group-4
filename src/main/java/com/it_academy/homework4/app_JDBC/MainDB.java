package com.it_academy.homework4.app_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.it_academy.homework4.app_JDBC.scannerMain.Menu.*;

public class MainDB {
    private static final String SQL_URL =
            "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\main\\myResources\\DBJM.db";

    public static void main(String[] args) {
        if (existDriver()) {
            try {
                Connection connection = DriverManager.getConnection(SQL_URL);
                startApp(connection);
            } catch (SQLException e) {
                System.out.println("Возникли проблемы с подключением к базе данных");
                throw new RuntimeException(e);
            }
        }
    }

}
