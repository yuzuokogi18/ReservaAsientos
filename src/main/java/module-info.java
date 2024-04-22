module com.example.registropasajeros {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.registropasajeros to javafx.fxml;
    exports com.example.registropasajeros;
    exports com.example.registropasajeros.Controllers;
    opens com.example.registropasajeros.Controllers to javafx.fxml;
}