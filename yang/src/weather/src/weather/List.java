package weather;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "main",
    "weather",
    "clouds",
    "dt_txt"
})
public class List {

    @JsonProperty("dt")
    private Long dt;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("weather")
    private java.util.List<Weather> weather = null;

    @JsonProperty("clouds")
    private Long clouds;
    
    @JsonProperty("dt_txt")
    private String dt_txt;
    
    

    @JsonProperty("dt")
    public Long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Long dt) {
        this.dt = dt;
    }


    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Temp main) {
        this.main = main;
    }


    @JsonProperty("weather")
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }


    @JsonProperty("clouds")
    public Long getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Long clouds) {
        this.clouds = clouds;
    }
    
    @JsonProperty("dt_txt")
    public String getDt_txt() {
        return dt_txt;
    }

    @JsonProperty("dt_txt")
    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    
}