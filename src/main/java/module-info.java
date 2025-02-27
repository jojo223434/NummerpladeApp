module com.example.nummerpladeapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nummerpladeapp to javafx.fxml;
    exports com.example.nummerpladeapp;
}