/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.dao;
import lombok.Data;
import java.util.LinkedList;
/**
 *
 * @author xy
 */
@Data
public class WeeklyData {
    
    
    private java.util.List<DailyData> WeeklyData = new LinkedList<>();
    
    
}
