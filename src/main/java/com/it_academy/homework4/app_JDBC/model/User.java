package com.it_academy.homework4.app_JDBC.model;

import java.util.Objects;

public class User {
    private int userId;
    private String name;
    private String address;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && name.equals(user.name) && address.equals(user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, address);
    }
}
