package com.timetracker.demo.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class dashboardController {

    @FXML
    public HBox centerContent;

    @FXML
    private Label welcomingText;

    @FXML
    public void setWelcomingText(String username){
        welcomingText.setText("Welcome back, " + username);
    }

    public void switchToLogHours(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        logHoursController controller = SceneUtils.switchCenter(stage, "logHours.fxml");
        // update user data in log hours, use Session.username

        //
        stage.show();
    }
}
