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
 * @author xy
 */
@Data
public class WeeklyData {

    private Date date;

    private Integer tempLow;
    private Integer tempHigh;
    private Double precip;

    public WeeklyData(Date inDate, Integer low, Integer high, Double precp) {
        setDate(inDate);

        setTempLow(low);
        setTempHigh(high);
        setPrecip(precp);

    }
    
   public WeeklyData(){
   }
}
