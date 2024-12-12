package com.example.weather_site;

public class WeatherData {
    private String city;
    private String temperature;
    private String condition;
    private String windSpeed;

    // Constructor
    public WeatherData(String city, String temperature, String condition, String windSpeed) {
        this.city = city;
        this.temperature = temperature;
        this.condition = condition;
        this.windSpeed = windSpeed;
    }

    // Getters and setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}


