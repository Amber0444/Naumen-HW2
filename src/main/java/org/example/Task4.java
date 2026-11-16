package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Task4 {
    // 4 вариант
    public static void main(String[] args) throws Exception {
        String jsonResponse = makeGetRequest();

        String acceptHeader = extractAcceptHeader(jsonResponse);

        System.out.println("Результат выполнения запроса:");
        if (acceptHeader != null) {
            System.out.println("Допустимые типы ответа (Accept): " + acceptHeader);
        }
    }

    public static String makeGetRequest() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/anything"))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Сервер вернул код: " + response.statusCode());
        }

        return response.body();
    }

    public static String extractAcceptHeader(String jsonResponse) {
        if (jsonResponse == null || jsonResponse.isEmpty()) {
            return null;
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonResponse);

            JsonNode acceptNode = rootNode.path("headers").path("Accept");

            if (acceptNode.isMissingNode() || acceptNode.isNull()) {
                return null;
            }
            return acceptNode.asText();

        } catch (Exception e) {
            System.err.println("Ошибка парсинга JSON: " + e.getMessage());
            return null;
        }
    }

}
