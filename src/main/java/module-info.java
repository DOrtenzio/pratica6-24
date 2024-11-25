module com.example.pratica824 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pratica824 to javafx.fxml;
    exports com.example.pratica824;
}