/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.service;

import com.weather.dao.CurrentData;
import java.util.Date;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author yifan
 */
@Service
public class OWMService {

    private OpenWeatherMap owm;
    //private DailyData dailyData;
    //private WeeklyData weeklyData;
    private CurrentData currentData;

    public OWMService() {
        owm = new OpenWeatherMap(OpenWeatherMap.Units.IMPERIAL, "ad83a65f4ccc238a791b4a89c56c1ff0");
    }

    public CurrentData getCurrent() throws Exception {
        CurrentWeather currentWeather = owm.currentWeatherByCityName("omaha");
        currentData = new CurrentData(new Date(),
                (int) currentWeather.getMainInstance().getTemperature(),
                (int) currentWeather.getMainInstance().getMaxTemperature(),
                (int) currentWeather.getMainInstance().getMinTemperature(),
                (double) currentWeather.getRainInstance().getRain());
        return currentData;
    }

}
