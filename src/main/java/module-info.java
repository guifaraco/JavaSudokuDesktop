module com.example.javadesktopsudokudemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javadesktopsudokudemo to javafx.fxml;
    exports com.example.javadesktopsudokudemo;
}