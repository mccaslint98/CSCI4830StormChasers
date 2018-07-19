package com.weather.domain;

import lombok.Data;

@Data
public class DailyMessageWeatherResponse {

    private City city;
    private String cod;
    private Float message;
    private Long cnt;

    private java.util.List<DailyDataList> list = null;

}
