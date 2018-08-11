package com.weather.domain;

import java.util.LinkedList;
import lombok.Data;

@Data
public class DailyWeatherResponse {

    private Coord coord;

    private java.util.List<Weather> weather = new LinkedList<>();

    private MainDailyData mdata;

    private Clouds clouds;

    private Rain rain;

    private long dt;

    private Sys sys;

    private int id;

    private String name;

    private int cod;

}
