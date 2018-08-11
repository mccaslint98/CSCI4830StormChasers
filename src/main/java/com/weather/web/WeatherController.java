/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.web;

import com.github.fedy2.weather.data.Channel;
import com.github.fedy2.weather.data.Item;
import com.weather.service.YahooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yifan
 */
@Controller
public class WeatherController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private YahooService yahooService;

    //@RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index() {
    //return "redirect:/forecast/lincoln";
//    }
    //@RequestMapping("/forecast/{city}")
    @RequestMapping("/")
    //public String getForecast(Model model, @PathVariable("city") String city) throws Exception {
    //public String getForecast(@PathVariable("city") String city) throws Exception {
    public String getForecast(Model model) throws Exception {

        Channel yahooResponse = yahooService.getDailytForecast("omaha");
        model.addAttribute("curTemp", yahooResponse.getItem().getCondition().getTemp() * 1.8 + 32);
        return "home";
    }

    @GetMapping("/faq")
    public String faq() {
        return "FAQ";
    }

    @GetMapping("/singlesource")
    public String singleSource(Model model) throws Exception {
        Channel yahooResponse = yahooService.getDailytForecast("omaha");
        Item item = yahooResponse.getItem();
        model.addAttribute("curTemp", item.getCondition().getTemp() * 1.8 + 32);
        model.addAttribute("tempHigh", item.getForecasts().get(0).getHigh() * 1.8 + 32);
        model.addAttribute("tempLow", item.getForecasts().get(0).getLow() * 1.8 + 32);
        return "singlesource";
    }

    @GetMapping("/history")
    public String history() {
        return "history";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        return Pages.ERROR;
    }
}
