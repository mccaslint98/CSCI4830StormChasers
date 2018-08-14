/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.service;

import com.github.dvdme.ForecastIOLib.ForecastIO;
import com.weather.dao.CurrentData;
import com.weather.dao.DailyData;
import com.weather.dao.WeeklyData;
import org.springframework.stereotype.Service;

/**
 *
 * @author yifan
 */
@Service
public class DarkSkyService {

    private String apiKey = "3f9a8b1e98bb647d9b132d7a0cd02692";
    private ForecastIO FIO;
    private static final String[] omaha = {"41.257160", "-95.995102"};
    private static final String[] licoln = {"40.806862", "-96.681679"};

    private CurrentData currentData;
    private DailyData dailyData;
    private WeeklyData weeklyData;

//    public DarkSkyService() {
//        FIO = new ForecastIO(apiKey);
//        FIO.setUnits(ForecastIO.UNITS_US);
//        lincolnFIO.setUnits(ForecastIO.UNITS_US);
//    }
//
//    public void getForecast() {
//
//    }
//
//    public CurrentData getCurrent() {
//        FIOCurrently fioCurrently = new FIOCurrently(omahaFIO);
//        FIODataPoint cur = fioCurrently.get();
//        currentData = new CurrentData(new Date(),
//                cur.temperature().intValue(),
//                cur.temperatureMax().intValue(),
//                cur.apparentTemperatureMin().intValue(),
//                cur.precipProbability());
//        return currentData;
//    }
//
//    public DailyDate getDaily() {
//    }
}
