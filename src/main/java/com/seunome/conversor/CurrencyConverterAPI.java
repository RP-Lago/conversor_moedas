package com.seunome.conversor;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class CurrencyConverterAPI {
    private static String API_KEY;
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    static {
        try (InputStream input = CurrencyConverterAPI.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.err.println("Desculpe, o arquivo config.properties não foi encontrado. Certifique-se de que ele está na raiz do projeto ou no classpath.");
                API_KEY = null;
            } else {
                prop.load(input);
                API_KEY = prop.getProperty("api.key");
                if (API_KEY == null || API_KEY.trim().isEmpty()) {
                    System.err.println("A chave 'api.key' não foi encontrada ou está vazia no config.properties.");
                }
            }
        } catch (IOException ex) {
            System.err.println("Erro ao carregar config.properties: " + ex.getMessage());
            API_KEY = null;
        }
    }

    public ExchangeRateResponse getConversionRate(String baseCurrency, String targetCurrency) throws IOException, InterruptedException {
        if (API_KEY == null || API_KEY.trim().isEmpty()) {
            System.err.println("Erro: API Key não configurada. Verifique seu arquivo config.properties.");
            return null;
        }

        String url = BASE_URL + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            return gson.fromJson(response.body(), ExchangeRateResponse.class);
        } else {
            System.err.println("Erro ao consultar a API: " + response.statusCode() + " - " + response.body());
            return null;
        }
    }
}
