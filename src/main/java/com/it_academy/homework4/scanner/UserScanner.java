package com.it_academy.homework4.scanner;

import com.it_academy.homework4.model.User;

import java.util.Objects;
import java.util.Scanner;

public class UserScanner {
    public static User inputUser (){
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите имя юзера: ");
            String nextLine = scanner.nextLine();
            if (!Objects.equals(nextLine, "")) {
                user.setName(nextLine);
                break;
            } else {
                System.out.println("Hеобходимо заполнить поле Имя");
            }
        }
        System.out.println("Введите адрес юзера: ");

        return user;

    }
}
