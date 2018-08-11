/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.dao;
import lombok.Data;
import com.weather.service.YahooService;

/**
 *
 * @author yifan
 */
@Data
public class DailyData {
    
    


   YahooService date;

    private Float Precipitation;
    
    YahooService tp ;
    
    YahooService temp_high;
    
    YahooService temp_low;
    
    

}
