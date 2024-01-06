module com.cgvsu {
    requires javafx.controls;
    requires javafx.fxml;
    requires vecmath;
    requires java.desktop;


    exports com.cgvsu.ui.controller;
    opens com.cgvsu.ui.controller to javafx.fxml;
    exports com.cgvsu.ui.application;
    opens com.cgvsu.ui.application to javafx.fxml;
}