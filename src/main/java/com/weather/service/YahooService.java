package com.weather.service;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Condition;
import com.github.fedy2.weather.data.Item;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import java.util.Date;
import java.util.HashMap;
import javax.xml.bind.JAXBException;
import org.springframework.stereotype.Service;
import com.weather.dao.CurrentData;
import com.weather.dao.DailyData;
import com.weather.dao.WeeklyData;

@Service
public class YahooService extends YahooWeatherService { //implements WeatherService<Channel> {
    
    private static final HashMap<String, String> VOEIDS;
    CurrentData cur;
    DailyData day;
    WeeklyData week;
    
    

    static {

        VOEIDS = new HashMap();
        VOEIDS.put("lincoln", "2439482");
        VOEIDS.put("omaha", "2465512");

    }

    public YahooService() throws JAXBException {
        super();
    }

    public Channel getDailytForecast(String city) throws Exception {
        
        
       Channel ch; 
        ch = getForecast(VOEIDS.get(city), DegreeUnit.FAHRENHEIT);
  
        return cur;
       }
     public Channel getItem() throws Exception {
         Channel it;
        it = getItem();
         return it;
     }


}
