package com.weather.domain;

import java.util.LinkedList;
import lombok.Data;

@Data
public class DailyDataList {

    private Long dt;

    private MainDailyData mdata;

    private java.util.List<Weather> weather = new LinkedList<>();

    private Long clouds;

    private String dt_txt;

}
