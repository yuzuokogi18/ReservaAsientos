package com.example.registropasajeros.Controllers;

import com.example.registropasajeros.Models.AsientoReservar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.List;

public class ReservarAsiento extends AsientoReservar {

    public Button reservarButton;
    public TextField eliminarasientoTextField1;
    private List<AsientoReservar> asientosReservados = new ArrayList<>();

    @FXML
    private TextField nombrepasajeroTextField;

    @FXML
    private TextField numeroasientoTextField;

    @FXML
    private Button eliminarButton;
    public ReservarAsiento() {
        super("", 0);

    }

    @FXML
    void onMouseClickreservarButton(ActionEvent event) {
        String nombrePasajero = nombrepasajeroTextField.getText().trim();
        String numeroAsientoStr = numeroasientoTextField.getText().trim();

        if (!nombrePasajero.isEmpty() && !numeroAsientoStr.isEmpty()) {
            try {
                int numeroAsiento = Integer.parseInt(numeroAsientoStr);
                if (numeroAsiento < 1 || numeroAsiento > 10) {
                    mostrarAlerta("El número de asiento debe estar entre 1 y 10.");
                    return;
                }

                if (asientosReservados.size() >= 10) {
                    mostrarAlerta("Ya se han reservado los 10 asientos disponibles.");
                    return;
                }
                for (AsientoReservar asiento : asientosReservados) {
                    if (asiento.getNumeroAsiento() == numeroAsiento) {
                        mostrarAlerta("El asiento " + numeroAsiento + " ya está ocupado.");
                        return;
                    }
                }
                mostrarAlertaConfirmacionReservar(nombrePasajero, numeroAsiento);
            } catch (NumberFormatException e) {
                mostrarAlerta("Ingrese un número válido para el asiento.");
            }
        } else {
            mostrarAlerta("Por favor, complete todos los campos.");
        }
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarAlertaConfirmacionReservar(String nombrePasajero, int numeroAsiento) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmación de reserva");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("¿Está seguro de reservar el asiento " + numeroAsiento + " para " + nombrePasajero + "?");

        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                AsientoReservar asiento = new AsientoReservar(nombrePasajero, numeroAsiento);
                asientosReservados.add(asiento);
                mostrarAlerta("Asiento reservado exitosamente.");
            } else {
                mostrarAlerta("Reserva cancelada.");
            }
        });
    }

    private void mostrarAlertaConfirmacionEliminar(AsientoReservar asiento) {
        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmación de eliminación");
        confirmAlert.setHeaderText(null);
        confirmAlert.setContentText("¿Está seguro de eliminar el asiento " + asiento.getNumeroAsiento() + " de " + asiento.getNombrePasajero() + "?");

        confirmAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                asientosReservados.remove(asiento);
                mostrarAlerta("Asiento eliminado exitosamente.");
            } else {
                mostrarAlerta("Eliminación cancelada.");
            }
        });
    }

    public void onMouseClickreliminarButton(ActionEvent actionEvent) {
        String numeroAsientoEliminar = eliminarasientoTextField1.getText().trim();
        if (!numeroAsientoEliminar.isEmpty()) {
            try {
                int numeroAsiento = Integer.parseInt(numeroAsientoEliminar);
                boolean encontrado = false;
                for (AsientoReservar asiento : asientosReservados) {
                    if (asiento.getNumeroAsiento() == numeroAsiento) {
                        encontrado = true;
                        mostrarAlertaConfirmacionEliminar(asiento);
                        break;
                    }
                }
                if (!encontrado) {
                    mostrarAlerta("No se encontró ningún asiento con el número proporcionado.");
                }
            } catch (NumberFormatException e) {
                mostrarAlerta("Ingrese un número válido para el asiento a eliminar.");
            }
        } else {
            mostrarAlerta("Ingrese el número de asiento que desea eliminar.");
        }
    }
    }
