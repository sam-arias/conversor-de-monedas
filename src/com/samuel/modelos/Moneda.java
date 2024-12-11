package com.samuel.modelos;

public class Moneda {
    String monedaOrigen;
    String monedaDestino;
    Double tasaCambio;

    public Moneda(MonedasAPI monedasAPI){
        this.monedaOrigen = monedasAPI.base_code();
        this.monedaDestino = monedasAPI.target_code();
        this.tasaCambio = Double.valueOf(monedasAPI.conversion_rate());
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public Double getTasaCambio() {
        return tasaCambio;
    }
}
