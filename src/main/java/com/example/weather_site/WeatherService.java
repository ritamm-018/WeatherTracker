package com.example.weather_site;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")  // Make sure this imports @Value correctly
    private String apiKey;

    private final String baseUrl = "http://api.weatherapi.com/v1/current.json";  // WeatherAPI base URL

    public String getWeather(String city) {
        String url = baseUrl + "?key=" + apiKey + "&q=" + city;
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        // Return the raw response to see if data is coming correctly
        return response;
    }
}
