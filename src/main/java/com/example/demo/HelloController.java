package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashMap;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    protected void onLoginButtonClick() throws Exception {
        UserDatabase database = new UserDatabase();

        // sample data
        database.addUser("mvkoksal", "hello123",1);
        database.addUser("abkoksal", "hello234",0);
        database.addUser("fkoksal", "hello345",0);

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Please enter your username and password");
        } else {
            if (database.checkLogin(username, password)) {
                System.out.println("Correct login and password!");
                System.out.println("You are type " + database.getUser(username).type);
            } else {
                System.out.println("Wrong login or password.");
            }
        }
        welcomeText.setText("Welcome Back!");
    }


}
