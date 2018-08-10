package com.weather.service;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.unit.DegreeUnit;
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

    public YahooService() throws JAXBException {
        super();
    }

    public Channel getDailytForecast(String city) throws Exception {

        Channel ch = getForecast(VOEIDS.get(city), DegreeUnit.CELSIUS);
        return ch;

    }

}
