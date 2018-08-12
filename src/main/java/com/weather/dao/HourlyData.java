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
public class HourlyData {

    private Integer hour;
    private Date date;

    private Integer temp;
    private Double precip;

    public HourlyData(Integer inHour, Date inDate, Integer inTemp, Double inPrecip) {
        setHour(inHour);
        setDate(inDate);
        setTemp(inTemp);
        setPrecip(inPrecip);
    }

    public HourlyData() {
    }

}
