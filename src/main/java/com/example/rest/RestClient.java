/*
 * CODTECH INTERNSHIP
 * TASK - 2: REST API CLIENT
 * Author: Bhakti Sharma
 * Date: 03-11-2025
 *
 * Description:
 * This Java program consumes the Open-Meteo public REST API
 * to fetch and display the current weather based on latitude
 * and longitude. It demonstrates the use of HttpClient and
 * JSON parsing with Jackson library.
 */


package com.example.rest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Scanner;

public class RestClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== REST API CLIENT (Weather Example) ===");
        System.out.print("Enter latitude (e.g., 35): ");
        String latitude = scanner.nextLine();
        System.out.print("Enter longitude (e.g., 139): ");
        String longitude = scanner.nextLine();

        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=" +
                latitude + "&longitude=" + longitude + "&current_weather=true";

        try {
            // 1. Create an HTTP client
            HttpClient client = HttpClient.newHttpClient();

            // 2. Create a GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            // 3. Send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Parse the JSON response
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            // 5. Extract specific fields
            JsonNode currentWeather = root.get("current_weather");

            System.out.println("\n--- Current Weather ---");
            System.out.println("Temperature: " + currentWeather.get("temperature").asText() + " °C");
            System.out.println("Wind Speed: " + currentWeather.get("windspeed").asText() + " m/s");
            System.out.println("Direction: " + currentWeather.get("winddirection").asText() + "°");
            System.out.println("Time: " + currentWeather.get("time").asText());
            System.out.println("-----------------------");

        } catch (IOException | InterruptedException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        }
    }
}
