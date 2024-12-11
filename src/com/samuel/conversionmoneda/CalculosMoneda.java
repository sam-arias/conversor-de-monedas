package com.samuel.conversionmoneda;

import com.samuel.modelos.Moneda;
import com.samuel.modelos.MonedasAPI;

import java.util.Scanner;

public class CalculosMoneda {

    public void conversionMoneda(String monedaOrigen, String monedaDestino, Scanner entrada) {
        double cantidadConvertir, totalConversion;

        // Validar la cantidad a convertir
        while (true) {
            System.out.println("Ingresa la cantidad a convertir: ");
            if (entrada.hasNextDouble()) {
                cantidadConvertir = entrada.nextDouble();
                break; // Sale del bucle cuando se ingresa una cantidad válida
            } else {
                System.out.println("Por favor ingresa un número válido para la cantidad.");
                entrada.next(); // Limpiar la entrada incorrecta
            }
        }

        try {
            ConsultaConversion conversion = new ConsultaConversion();
            MonedasAPI monedasAPI = conversion.obtenerConversion(monedaOrigen, monedaDestino);

            Moneda monedaConvertida = new Moneda(monedasAPI);
            totalConversion = monedaConvertida.getTasaCambio() * cantidadConvertir;

            System.out.println("El valor ingresado $" + cantidadConvertir + " [" + monedaOrigen +
                    "] equivale a $" + String.format("%.4f", totalConversion) + " [" + monedaDestino + "]");

        }catch (NumberFormatException e) {
            System.out.println("Error, ingresa un número valido");
        }
    }

    // Metodo para convertir cualquier tipo de moneda con su codigo ISO
    public void conversionCualquierMoneda() {
        Scanner entrada = new Scanner(System.in);
        String monedaOrigen, monedaDestino;

        System.out.println("Ingrese el código de la moneda de origen: ");
        monedaOrigen = entrada.next();
        System.out.println("Ingresa el código de la moneda de destino: ");
        monedaDestino = entrada.next();

        conversionMoneda(monedaOrigen, monedaDestino, entrada);
    }
}
