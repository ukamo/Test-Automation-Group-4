package com.it_academy.homework4.app_JDBC.scannerFromModel;

import com.it_academy.homework4.app_JDBC.model.User;
import com.it_academy.homework4.app_JDBC.scannerMain.ScannerHelper;

import java.sql.Connection;
import java.util.Scanner;

public class UserScanner {
    public static User inputUser(Connection connection) {
        User user = new User();
        ScannerHelper scannerHelper = new ScannerHelper(connection);
        user.setName(scannerHelper.scanNewUser());
        System.out.println("Введите адрес юзера: ");
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        user.setAddress(nextLine);
        return user;

    }
}
