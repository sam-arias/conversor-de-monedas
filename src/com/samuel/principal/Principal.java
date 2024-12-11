package com.samuel.principal;

import com.samuel.conversionmoneda.CalculosMoneda;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);

        CalculosMoneda conversion = new CalculosMoneda();

        System.out.println("**BIENVENIDOS A MI CONVERSOR DE MONEDAS**\n");

        // Menu de conversiones de las monedas
        String monedasCode = """
                Ingresa una opción de conversión de moneda.☺
                1.Dólar -> Peso argentino
                2.Dólar -> Peso colombiano
                3.Dólar -> Real brasileño
                4.Peso colombiano -> Peso chileno
                5.Peso colombiano -> Peso argentino
                6.Sol peruano -> Dólar
                7.Convertir a otra moneda
                0.Salir
                """;

        int opcion = -1;
        while (true) {
            try {
                // Validar la opción de conversión
                while (opcion < 0 || opcion > 7) {
                    System.out.println(monedasCode);
                    if (entrada.hasNextInt()) {
                        opcion = entrada.nextInt();
                    } else {
                        System.out.println("¡Por favor ingresa un número válido!\n");
                        entrada.next(); // Limpiar la entrada incorrecta
                        continue;
                    }
                }

                // Nos salimos si la opción es 0
                if (opcion == 0) {
                    break;
                }

                // Realizar la conversión según la opción seleccionada
                switch (opcion) {
                    case 1:
                        conversion.conversionMoneda("USD", "ARS", entrada);
                        break;
                    case 2:
                        conversion.conversionMoneda("USD", "COP", entrada);
                        break;
                    case 3:
                        conversion.conversionMoneda("USD", "BRL", entrada);
                        break;
                    case 4:
                        conversion.conversionMoneda("COP", "CLP", entrada);
                        break;
                    case 5:
                        conversion.conversionMoneda("COP", "ARS", entrada);
                        break;
                    case 6:
                        conversion.conversionMoneda("PEN", "USD", entrada);
                        break;
                    case 7:
                        conversion.conversionCualquierMoneda();
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Error en ejecución: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ups, algo salió mal :[");
            } finally {
                if (opcion != 0) {
                    System.out.println("Conversión Finalizada =] \n");
                    opcion = -1; // Restablecer la opción para volver a pedirla
                }
            }
        }
        entrada.close();
        System.out.println("☻Finalizando la aplicación☻");
    }
}
