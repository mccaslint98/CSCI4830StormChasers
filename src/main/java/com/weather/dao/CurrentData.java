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
 * @author xxxxy
 */
@Data
public class CurrentData {

    private Date date;

    private Integer temp;
    private Integer low;
    private Integer high;
    private Double precipProbability;

    public CurrentData(Date inDate, Integer inTemp, Integer inHigh, Integer inLow, Double inPrecip) {
        setDate(inDate);
        setTemp(inTemp);
        setLow(inLow);
        setHigh(inHigh);
        setPrecipProbability(inPrecip);
    }
   public CurrentData(){       
   }

}
