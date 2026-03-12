package com.timetracker.demo.model;

import java.security.MessageDigest;
import java.util.Base64;

public class User {
    private String username;
    private String password;
    public int type;
    // type = 0 -> employee, type = 1 -> employer

    public User(String username, String password, int type) throws Exception {
        this.username = username;
        this.password = hashPassword(password);
        this.type = type;
    }
    public String getPassword() {
        return password;
    }

    public static String hashPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }


}
