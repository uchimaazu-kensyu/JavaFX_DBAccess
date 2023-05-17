module com.example.javafxtest2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxtest2 to javafx.fxml;
    exports com.example.javafxtest2;
    exports DBClass;
    opens DBClass to javafx.fxml;
}