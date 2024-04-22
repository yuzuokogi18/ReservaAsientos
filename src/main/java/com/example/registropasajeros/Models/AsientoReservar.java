package com.example.registropasajeros.Models;

public class AsientoReservar  {

    private String nombrePasajero;
    private int numeroAsiento;


    public AsientoReservar(String nombrePasajero, int numeroAsiento) {
        this.nombrePasajero = nombrePasajero;
        this.numeroAsiento = numeroAsiento;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }
}
