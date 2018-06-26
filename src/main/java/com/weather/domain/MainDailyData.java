package com.weather.domain;

import lombok.Data;

@Data
public class MainDailyData {

    private Float temp;

    private Float temp_min;

    private Float temp_max;

    private Long humidity;

}
