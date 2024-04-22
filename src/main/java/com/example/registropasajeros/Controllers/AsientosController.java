package com.example.registropasajeros.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.registropasajeros.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AsientosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button eliminarasientoButton;

    @FXML
    private Button reservarasientobutton;

    @FXML
    private Button salirButton;



    @FXML
    void onMouseClickreservarasientoButton(MouseEvent event) {
        try {
            App.changeScene("ReservarAsiento.fxml", 900, 600, (Stage) reservarasientobutton.getScene().getWindow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onMouseClicksalirButton(MouseEvent event) {
        Stage stage = (Stage) salirButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void initialize() {


    }

}
