module com.example.demojava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demojava to javafx.fxml;
    exports com.example.demojava;
}