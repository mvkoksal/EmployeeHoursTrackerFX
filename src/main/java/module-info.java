module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.timetracker.demo to javafx.fxml;
    exports com.timetracker.demo;
    exports com.timetracker.demo.controllers;
    opens com.timetracker.demo.controllers to javafx.fxml;
    exports com.timetracker.demo.model;
    opens com.timetracker.demo.model to javafx.fxml;
    exports com.timetracker.demo.service;
    opens com.timetracker.demo.service to javafx.fxml;
}