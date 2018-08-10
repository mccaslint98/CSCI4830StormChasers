package com.weather.service;

public interface WeatherService<DailyMessageWeatherResponse> {

    public DailyMessageWeatherResponse getDailytForecast(String city) throws Exception;

}
