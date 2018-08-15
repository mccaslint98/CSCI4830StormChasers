/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.service;

import com.weather.dao.CurrentData;
import com.weather.dao.DailyData;
import com.weather.dao.WeeklyData;
import java.io.IOException;
import java.util.Date;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;
import org.springframework.stereotype.Service;

/**
 *
 * @author yifan
 */
@Service
public class OWMService implements WeatherService {

    private OpenWeatherMap owm;
    private DailyData dailyData;
    private CurrentData currentData;

    public OWMService() {
        owm = new OpenWeatherMap(OpenWeatherMap.Units.IMPERIAL, "ad83a65f4ccc238a791b4a89c56c1ff0");
    }

    @Override
    public void getDailyForecast(String city) {
    }

    @Override
    public CurrentData getCurrent() {
        try {
            CurrentWeather currentWeather = owm.currentWeatherByCityName("omaha");
            currentData = new CurrentData(new Date(),
                    (int) currentWeather.getMainInstance().getTemperature(),
                    (int) currentWeather.getMainInstance().getMaxTemperature(),
                    (int) currentWeather.getMainInstance().getMinTemperature(),
                    (currentWeather.hasRainInstance() ? currentWeather.getRainInstance().getRain() : 0.0));

            return currentData;
        } catch (IOException | JSONException ioe) {
            System.out.println(ioe);
        }
        return new CurrentData(new Date(), 0, 0, 0, 0.0);
    }

    @Override
    public DailyData getDaily() {
//        try {
//            HourlyForecast hourlyForecast = owm.hourlyForecastByCityName("omaha");
//
//            HourlyData[] hourlyData = new HourlyData[24];
//            for (int i = 0; i < 24 && i < hourlyForecast.getForecastCount(); i++) {
//                HourlyForecast.Forecast temp = hourlyForecast.getForecastInstance(i);
//                hourlyData[i] = new HourlyData(i, temp.getDateTime(),
//                        (int) temp.getMainInstance().getTemperature(),
//                        0.0);
//                dailyData = new DailyData(temp.getDateTime(), hourlyData);
//                return dailyData;
//
//            }
//        } catch (IOException | JSONException ioe) {
//            System.out.println(ioe);
//        }
        return dailyData;
    }

    @Override
    public WeeklyData[] getWeekly() {
        WeeklyData[] weeklyData = new WeeklyData[7];
        try {
            DailyForecast dailyForecast = owm.dailyForecastByCityName("omaha", (byte) 7);

            for (int i = 0; i < dailyForecast.getForecastCount() && i < 7; i++) {
                DailyForecast.Forecast temp = dailyForecast.getForecastInstance(i);
                weeklyData[i] = new WeeklyData(temp.getDateTime(),
                        (int) temp.getTemperatureInstance().getMinimumTemperature(),
                        (int) temp.getTemperatureInstance().getMaximumTemperature(),
                        (double) temp.getRain());
            }
            return weeklyData;

        } catch (IOException | JSONException ioe) {
            System.out.println(ioe);
        }
        return weeklyData;
    }
    private DailyData getDaily() throws Exception {
        DailyForecast dailyForecast = owm.dailyForecastByCityName("omaha");
        dailyData = new DailyData(new Date(),
                (int)dailyForecast.getMainInstance().getTemperature(),
                (int) dailyForecast.getMainInstance().getMaxTemperature(),
                (int) dailyForecast.getMainInstance().getMinTemperature());
        return dailyData;
    }
//    private WeeklyData getDaily() throws Exception {
//        
//    }
}

