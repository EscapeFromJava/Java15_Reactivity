module com.example.java15_reactivity {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java15_reactivity to javafx.fxml;
    exports com.example.java15_reactivity;
}