package com.weather.service;

import com.weather.domain.DailyMessageWeatherResponse;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherServiceImpl implements WeatherService {

    private UriComponentsBuilder urlbuilder;

    @Autowired
    RestTemplate restTemplate;

    @PostConstruct
    protected void init() {

        urlbuilder = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("api.openweathermap.org")
                .path("/data/2.5/forecast")
                .queryParam("cnt", "3")
                .queryParam("mode", "json")
                .queryParam("units", "metric")
                .queryParam("appid", "ad83a65f4ccc238a791b4a89c56c1ff0");

    }

    @Override
    public DailyMessageWeatherResponse getDailytForecast(String city) {
        String url = urlbuilder.replaceQueryParam("q", city).build().toUriString();
        DailyMessageWeatherResponse resp = new DailyMessageWeatherResponse();
        try {
            resp = restTemplate.getForObject(url, DailyMessageWeatherResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

}
/**
 *
 * {
 * "coord": { "lon": 139, "lat": 35 }, "sys": { "country": "JP", "sunrise":
 * 1369769524, "sunset": 1369821049 }, "weather": [{ "id": 804, "main":
 * "clouds", "description": "overcast clouds", "icon": "04n" }], "main": {
 * "temp": 289.5, "humidity": 89, "pressure": 1013, "temp_min": 287.04,
 * "temp_max": 292.04 }, "wind": { "speed": 7.31, "deg": 187.002 }, "rain": {
 * "3h": 0 }, "clouds": { "all": 92 }, "dt": 1369824698, "id": 1851632, "name":
 * "Shuzenji", "cod": 200 }
 *
 *
 */
