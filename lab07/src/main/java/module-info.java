module com.example.lab07 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens lab7 to javafx.fxml;
    exports lab7;
}