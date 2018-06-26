package com.weather.domain;

import lombok.Data;

@Data
public class DailyMessageWeatherResponse {

    //private location city;
    private Coord coord;

    private String country;

    private String cod;

    private Float message;

    private Long cnt;

    private java.util.List<DailyDataList> list = null;

}
