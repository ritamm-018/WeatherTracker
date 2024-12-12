package com.example.weather_site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherData getWeather(@RequestParam String city) {
        // Call the WeatherService to get weather data for the city
        String weatherDataJson = weatherService.getWeather(city);

        // Print the raw JSON to check its structure
        System.out.println("Weather Data JSON: " + weatherDataJson);

        // Parse the JSON data into a WeatherData object
        WeatherData data = parseWeatherData(weatherDataJson);

        return data;
    }

    private WeatherData parseWeatherData(String weatherDataJson) {
        try {
            // Use Jackson ObjectMapper to parse JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(weatherDataJson);

            // Extract weather data fields
            String city = rootNode.path("location").path("name").asText();
            String temperature = rootNode.path("current").path("temp_c").asText() + "°C";
            String condition = rootNode.path("current").path("condition").path("text").asText();
            String windSpeed = rootNode.path("current").path("wind_kph").asText() + " km/h";

            // Return the parsed data in a WeatherData object
            return new WeatherData(city, temperature, condition, windSpeed);
        } catch (Exception e) {
            e.printStackTrace();
            // Return a default response in case of error
            return new WeatherData("Error", "N/A", "N/A", "N/A");
        }
    }
}






