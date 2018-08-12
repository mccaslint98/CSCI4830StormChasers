/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.dao;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author yifan
 */
@Data
public class DailyData {

    private Date date;

    private HourlyData[] hourly;

    public DailyData(Date inDate, HourlyData[] inHourly) {
        setDate(inDate);
        setHourly(inHourly);
    }

    public DailyData() {
    }

}
