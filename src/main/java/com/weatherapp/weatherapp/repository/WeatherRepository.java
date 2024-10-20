package com.weatherapp.weatherapp.repository;

import com.weatherapp.weatherapp.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    List<Weather> findByCityAndTimestamp(String city, Long timestamp);
}
