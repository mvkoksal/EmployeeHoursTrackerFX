package com.timetracker.demo.controllers;

import com.timetracker.demo.TimeTrackerApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneUtils {

    public static Stage clickSwitchScene(MouseEvent event, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TimeTrackerApplication.class.getResource(fxmlFile));
        Parent root = fxmlLoader.load();

        // Gets a reference to the stage using the current event
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.getScene().setRoot(root);
        return stage;
    }

    public static <T> T switchCenter(Stage stage, String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TimeTrackerApplication.class.getResource(fxmlFile));
        Parent newCenter = fxmlLoader.load();
        BorderPane root = (BorderPane) stage.getScene().getRoot();
        root.setCenter(newCenter);
        return fxmlLoader.getController();
    }
}
