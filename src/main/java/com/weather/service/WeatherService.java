package com.weather.service;

import com.weather.domain.DailyMessageWeatherResponse;


public interface WeatherService{

    public DailyMessageWeatherResponse getDailytForecast(String city) throws Exception;

}