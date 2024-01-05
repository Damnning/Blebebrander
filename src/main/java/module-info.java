module com.cgvsu {
    requires javafx.controls;
    requires javafx.fxml;
    requires vecmath;
    requires java.desktop;


    exports com.cgvsu.original;
    opens com.cgvsu.original to javafx.fxml;
    //todo: Хорошо бы перевести с Maven на Gradle
}