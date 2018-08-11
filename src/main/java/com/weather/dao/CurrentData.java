/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.dao;
//import com.github.fedy2.weather.data.Channel;
import com.weather.service.YahooService;
import lombok.Data;
/**
 *
 * @author xxxxy
 */
@Data
public class CurrentData {
    
        private YahooService ch;
        private YahooService date;
        
    
}
