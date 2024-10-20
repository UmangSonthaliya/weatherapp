package com.weatherapp.weatherapp.service;

import com.weatherapp.weatherapp.model.Weather;
import com.weatherapp.weatherapp.repository.WeatherRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class WeatherService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
    @Autowired
    private WeatherRepository weatherRepository;

    private final String API_KEY = "29ff0c7ff746df5141f9e8c6da5b2ebf"; // Update your API key
    private final List<String> CITIES = List.of("Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad");

    @Scheduled(fixedRate = 300000) // Every 5 minutes
    public void fetchWeatherData() {
        RestTemplate restTemplate = new RestTemplate();

        for (String city : CITIES) {
            String url = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city, API_KEY);
            WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);
            if (response != null) {
                saveWeatherData(response);
            }
        }
    }

    private void saveWeatherData(WeatherResponse response) {
        // Find if a record exists for the same city and timestamp
        List<Weather> existingWeathers = weatherRepository.findByCityAndTimestamp(response.getName(), response.getDt());

        if (!existingWeathers.isEmpty()) {
            // If a record exists, update the first one found
            Weather existingWeather = existingWeathers.get(0); // Get the first matching weather data
            existingWeather.setTemperature(kelvinToCelsius(response.getMain().getTemp()));
            existingWeather.setWeatherCondition(response.getWeather().get(0).getMain());
            weatherRepository.save(existingWeather);
            logger.info("Updated weather data for {} at timestamp {}", response.getName(), response.getDt());
        } else {
            // If no record exists, insert a new one
            Weather newWeather = new Weather();
            newWeather.setCity(response.getName());
            newWeather.setTemperature(kelvinToCelsius(response.getMain().getTemp()));
            newWeather.setWeatherCondition(response.getWeather().get(0).getMain());
            newWeather.setTimestamp(response.getDt());
            weatherRepository.save(newWeather);
            logger.info("Inserted new weather data for {} at timestamp {}", response.getName(), response.getDt());
        }
    }


    public List<Weather> getAllWeatherData() {
        return weatherRepository.findAll();
    }

    private double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
}
