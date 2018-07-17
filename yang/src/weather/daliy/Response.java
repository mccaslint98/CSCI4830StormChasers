package weather;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import weather.Long;
import weather.Main;
import weather.Temp;
import weather.Weather;
import weather.java;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
   
    "coord",
    "weather"
    "main",
    "clouds"
    "rain",
    "sys",
    "id",
    "name"
 
})
public class Response {
	
	
	    @JsonProperty("coord")
	    private Coord coord;

	    @JsonProperty("weather")
	    private java.util.List<Weather> weather = null;

	    @JsonProperty("main")
	    private Main main;

	    @JsonProperty("clouds")
	    private Cloulds clouds;
	    
	    @JsonProperty("rain")
	    private Rain rain;
	    
	    @JsonProperty("sys")
	    private Sys sys;
	    
	    @JsonProperty("id")
	    private int id;

	    @JsonProperty("name")
	    private String name;
	    

	    
	    @JsonProperty("coord")
	    public Coord getCoord() {
	        return coord;
	    }

	    @JsonProperty("coord")
	    public void setCoord(Coord coord) {
	        this.coord = coord;
	    }


	    @JsonProperty("weather")
	    public java.util.List<Weather> getWeather() {
	        return weather;
	    }

	    @JsonProperty("weather")
	    public void setWeather(java.util.List<Weather> weather) {
	        this.weather = weather;
	    }

	    
	    @JsonProperty("main")
	    public Main getMain() {
	        return main;
	    }

	    @JsonProperty("main")
	    public void setMain(Main main) {
	        this.main = main;
	    }
	    
	    @JsonProperty("clouds")
	    public Cloulds getClouds() {
	        return clouds;
	    }

	    @JsonProperty("clouds")
	    public void setCloulds(Cloulds clouds) {
	        this.clouds = clouds;
	    }

	    @JsonProperty("rain")
	    public Rain getRain() {
	        return rain;
	    }

	    @JsonProperty("rain")
	    public void setRain(Rain rain) {
	        this.rain = rain;
	    }
	    
	    @JsonProperty("sys")
	    public Sys getsys() {
	        return sys;
	    }

	    @JsonProperty("sys")
	    public void setSys(Sys sys) {
	        this.sys = sys;
	    }
	    
	    @JsonProperty("id")
	    public int getId() {
	        return id;
	    }

	    @JsonProperty("id")
	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    @JsonProperty("name")
	    public String getName() {
	        return name;
	    }

	    @JsonProperty("name")
	    public void setName(String name) {
	        this.name = name;
	    }

}
