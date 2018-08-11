package com.weather.service;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Condition;
import com.github.fedy2.weather.data.Forecast;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import java.util.Date;
import java.util.HashMap;
import javax.xml.bind.JAXBException;
import org.springframework.stereotype.Service;


@Service
public class YahooService extends YahooWeatherService { //implements WeatherService<Channel> {
    
    private static final HashMap<String, String> VOEIDS;

    
    

    static {

        VOEIDS = new HashMap();
        VOEIDS.put("lincoln", "2439482");
        VOEIDS.put("omaha", "2465512");

    }

    //public YahooService() throws JAXBException {
        //super();
    //}

    public Channel getDailytForecast(String city) throws Exception {
        
        
       Channel ch; 
        ch = getForecast(VOEIDS.get(city), DegreeUnit.FAHRENHEIT);
  
        return ch;
       }
   
    public  Condition getDate()throws Exception{
        Condition date = getDate();
        return date ;
     }
    
    public Condition getTemp() throws Exception {
         Condition tp = getTemp();
     
         return tp;
     }
    public Forecast getHigh() throws Exception{
         Forecast temp_high = getHigh();
         return temp_high;
     }
    public Forecast getLow() throws Exception{
         Forecast temp_low = getLow();
         return temp_low;
     }

}
