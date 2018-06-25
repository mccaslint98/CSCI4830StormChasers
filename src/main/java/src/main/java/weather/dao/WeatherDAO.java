package src.main.java.weather.dao;

import java.util.ArrayList;
import view.Weather;

public class WeatherDAO {
	public ArrayList<Weather> getWeather(String city,String source){
		Weather weather1 = new Weather(city,"12AM","MON",source,80,61,83,6);
		Weather weather2 = new Weather(city,"12AM","MON",source,80,61,83,6);
		ArrayList<Weather> weatherList = new ArrayList<Weather>();
		weatherList.add(weather1);
		weatherList.add(weather2);
		return weatherList;
	}
}
