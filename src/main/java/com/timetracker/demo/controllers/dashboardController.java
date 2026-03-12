package com.timetracker.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class dashboardController {

    @FXML
    private Label welcomingText;

    @FXML
    public void setWelcomingText(String username){
        welcomingText.setText("Welcome back, " + username);
    }

}
