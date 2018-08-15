/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.web;

import com.weather.dao.CurrentData;
import com.weather.service.DarkSkyService;
import com.weather.service.OWMService;
import com.weather.service.YahooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    @Autowired
    private OWMService owmService;
    @Autowired
    private DarkSkyService darkSkyService;

    //@RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index() {
    //return "redirect:/forecast/lincoln";
//    }
    //@RequestMapping("/forecast/{city}")
    @RequestMapping("/")
    //public String getForecast(Model model, @PathVariable("city") String city) throws Exception {
    //public String getForecast(@PathVariable("city") String city) throws Exception {
    public String getForecast(Model model) {
        //model.addAttribute("command", new MultSFormCommand());

        yahooService.getDailyForecast("omaha");
        model.addAttribute("hourlyDatas", yahooService.getDaily().getHourly());
        model.addAttribute("yahooweeklyDatas", yahooService.getWeekly());

        darkSkyService.getDailyForecast("omaha");
        CurrentData currentData = darkSkyService.getCurrent();
        model.addAttribute("curTemp", currentData.getTemp());
        model.addAttribute("darkskyhourlyDatas", darkSkyService.getDaily().getHourly());

        model.addAttribute("weeklyDatas", darkSkyService.getWeekly());

        //model.addAttribute("owmweeklyDatas", owmService.getWeekly());
        return "home";
    }

    @ModelAttribute("multiCheckboxAllValues")
    public String[] getMultiCheckboxAllValues() {
        return new String[]{
            "OWM", "DarkSky", "NOAA"
        };
    }

    @PostMapping("/")
    public String multiFormPost(@ModelAttribute MultSFormCommand command, Model model) {
        yahooService.getDailyForecast("omaha");
        model.addAttribute("curTemp", yahooService.getCurrent().getTemp());
        model.addAttribute("hourlyDatas", yahooService.getDaily().getHourly());
        return "home";
    }

    @GetMapping("/faq")
    public String faq() {
        return "FAQ";
    }

    @GetMapping("/singlesource")
    public String singleSource(Model model) {
        yahooService.getDailyForecast("omaha");
        CurrentData currentData = yahooService.getCurrent();
        //CurrentData currentData = darkSkyService.getCurrent();

        model.addAttribute("curTemp", currentData.getTemp());
        model.addAttribute("tempHigh", currentData.getHigh());
        model.addAttribute("tempLow", currentData.getLow());
        model.addAttribute("weeklyDatas", yahooService.getWeekly());

        darkSkyService.getDailyForecast("omaha");
        model.addAttribute("hourlyDatas", darkSkyService.getDaily().getHourly());
        return "singlesource";
    }

    @GetMapping("/history")
    public String history(Model model) {
        yahooService.getDailyForecast("omaha");
        model.addAttribute("curTemp", yahooService.getCurrent().getTemp());
        return "history";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e) {
        return Pages.ERROR;
    }
}
