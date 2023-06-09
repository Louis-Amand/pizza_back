package com.example.pizza_back.entity;

public class User {
    private String email;
    private String password;

    /**
     * @param name
     * @param email
     * @param password
     * @param phone
     * @param address
     */
    public User(String name, String email, String password, String phone, String address) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
