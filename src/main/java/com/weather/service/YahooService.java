package com.weather.service;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Forecast;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.weather.dao.CurrentData;
import com.weather.dao.DailyData;
import com.weather.dao.HourlyData;
import com.weather.dao.WeeklyData;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.JAXBException;
import org.springframework.stereotype.Service;

@Service
public class YahooService extends YahooWeatherService { //implements WeatherService<Channel> {

    private static final HashMap<String, String> VOEIDS;
    private Channel ch;

    private DailyData daily;

    static {

        VOEIDS = new HashMap();
        VOEIDS.put("lincoln", "2439482");
        VOEIDS.put("omaha", "2465512");

    }

    public YahooService() throws JAXBException {
        super();
    }

    public void getDailytForecast(String city) throws Exception {

        ch = getForecast(VOEIDS.get(city), DegreeUnit.FAHRENHEIT);
    }

    public DailyData getDaily() {
        HourlyData[] hourly = new HourlyData[24];
        Date date = new Date();
        for (int i = 0; i < 24; i++) {
            hourly[i] = new HourlyData(i, date, (72 + i), new Double(0));
        }
        daily = new DailyData(date, hourly);
        return daily;
    }

    public WeeklyData[] getWeekly() {

        List<Forecast> forecasts = ch.getItem().getForecasts();

        WeeklyData[] weeklyData = new WeeklyData[7];

        Iterator<Forecast> itr = forecasts.iterator();
        int count = 0;
        while (itr.hasNext() && count < 7) {
            Forecast temp = itr.next();
            weeklyData[count++] = new WeeklyData(temp.getDate(), temp.getHigh(), temp.getLow(), new Double(0.0));
        }
        return weeklyData;
    }

    public CurrentData getCurrent() {
        int temp = ch.getItem().getCondition().getTemp();
        Forecast forecast = ch.getItem().getForecasts().get(0);
        return new CurrentData(forecast.getDate(), temp, forecast.getHigh(), forecast.getLow(), new Double(0.0));
    }

}
