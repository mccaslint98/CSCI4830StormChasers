package com.weather.service;

import com.weather.dao.CurrentData;
import com.weather.dao.DailyData;
import com.weather.dao.WeeklyData;

public interface WeatherService {

    public void getDailyForecast(String city);

    public CurrentData getCurrent();

    public DailyData getDaily();

    public WeeklyData[] getWeekly();

}
