package com.weatherapp.weatherapp.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherResponse {
    private Main main; // Object holding main weather details
    private List<Weather> weather; // List of weather conditions
    private String name; // Name of the city
    private long dt; // Timestamp of the weather data

    // Getters and Setters for WeatherResponse fields

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    // Inner class for Main weather details
    public static class Main {
        @JsonProperty("temp") // Maps the JSON "temp" field to this variable
        private double temp; // Current temperature in Kelvin

        // Getter and Setter for temperature
        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }
    }

    // Inner class for Weather details
    public static class Weather {
        private String main; // Main weather condition (e.g., Clear, Rain)

        // Getter and Setter for weather condition
        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }
    }
}
