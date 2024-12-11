package com.samuel.conversionmoneda;

import com.google.gson.Gson;
import com.samuel.modelos.MonedasAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {
    public MonedasAPI obtenerConversion(String monedaOrigen, String monedaDestino) {
        String APIKey = "2721f6f360574bc59514ff5b";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + APIKey + "/pair/"
                + monedaOrigen + "/" + monedaDestino + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MonedasAPI.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No encontre esa moneda.");
        }
    }
}
