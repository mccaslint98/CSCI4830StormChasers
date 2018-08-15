/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.service;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.FIODaily;
import com.github.dvdme.ForecastIOLib.FIODataPoint;
import com.github.dvdme.ForecastIOLib.FIOHourly;
import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.weather.dao.CurrentData;
import com.weather.dao.DailyData;
import com.weather.dao.HourlyData;
import com.weather.dao.WeeklyData;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author yifan
 */
@Service
public class DarkSkyService implements WeatherService {

    private final String apiKey = "3f9a8b1e98bb647d9b132d7a0cd02692";
    private ForecastIO fio;
    private static final String[] omaha = {"41.257160", "-95.995102"};
    private static final String[] licoln = {"40.806862", "-96.681679"};

    private CurrentData currentData;
    private DailyData dailyData;

    public DarkSkyService() {
        fio = new ForecastIO(apiKey);
        fio.setUnits(ForecastIO.UNITS_US);
    }

    @Override
    public void getDailyForecast(String city) {
        fio.getForecast("41.257160", "-95.995102");
    }

    @Override
    public CurrentData getCurrent() {
        FIOCurrently currently = new FIOCurrently(fio);
        FIODataPoint curDataPoint = currently.get();
        if (curDataPoint != null) {
            currentData = new CurrentData(new Date(),
                    curDataPoint.temperature().intValue(),
                    0,
                    0,
                    //        0.0);
                    //curDataPoint.temperatureMax().intValue(),
                    //curDataPoint.temperatureMin().intValue(),
                    curDataPoint.precipProbability() * 100.0);
        } else {
            currentData = new CurrentData(new Date(),
                    72,
                    72,
                    72,
                    0.0);
        }
        return currentData;

    }

    @Override
    public DailyData getDaily() {
        FIOHourly hourly = new FIOHourly(fio);
        HourlyData[] hourlyData = new HourlyData[24];
        Date date = new Date();
        for (int i = 0; i < 24; i++) {
            FIODataPoint temp = hourly.getHour(i);
            hourlyData[i] = new HourlyData(i, date,
                    temp.temperature().intValue(),
                    temp.precipProbability() * 100);

        }
        dailyData = new DailyData(date, hourlyData);
        return dailyData;
    }

    @Override
    public WeeklyData[] getWeekly() {
        WeeklyData[] weeklyData = new WeeklyData[7];
        FIODaily daily = new FIODaily(fio);
        Date date = new Date();

        for (int i = 0; i < daily.days() && i < 7; i++) {
            FIODataPoint temp = daily.getDay(i);
            weeklyData[i] = new WeeklyData(date,
                    temp.temperatureMin().intValue(),
                    temp.temperatureMax().intValue(),
                    temp.precipProbability() * 100);

        }
        return weeklyData;

    }
}
