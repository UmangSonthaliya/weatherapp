package com.weatherapp.weatherapp.controller;

import com.weatherapp.weatherapp.model.Weather;
import com.weatherapp.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public List<Weather> getWeatherData() {
        return weatherService.getAllWeatherData();
    }
}
