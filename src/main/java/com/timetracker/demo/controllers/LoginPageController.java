package com.timetracker.demo.controllers;

import com.timetracker.demo.TimeTrackerApplication;
import com.timetracker.demo.service.UserDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws Exception {
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

                Session.username = username;
                Session.userType = database.getUser(username).type;

                switchToDashboard(event);
            } else {
                System.out.println("Wrong login or password.");
            }
        }
        welcomeText.setText("Welcome Back!");
    }

    @FXML
    public void switchToDashboard(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TimeTrackerApplication.class.getResource("dashboard.fxml"));
        Parent root = fxmlLoader.load();

        // Gets a reference to the stage using the current event
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);

        dashboardController controller = fxmlLoader.getController();
        controller.setWelcomingText(usernameField.getText());
        stage.show();
    }

}
