package com.timetracker.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class TimeTrackerApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        // Load Fonts
        Font.loadFont(getClass().getResourceAsStream("/fonts/PlusJakartaSans-Regular.ttf"), 0);
        Font.loadFont(getClass().getResourceAsStream("/fonts/PlusJakartaSans-Bold.ttf"), 0);

        FXMLLoader fxmlLoader = new FXMLLoader(TimeTrackerApplication.class.getResource("loginPage.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);

        stage.setTitle("Demo Application");
        // during development OFF
        stage.setMaximized(true);
        //stage.setResizable(false);
        stage.setX(50);
        stage.setY(50);

        stage.setScene(scene);
        stage.show();

    }
}
