package com.weather.web;

import com.weather.domain.DailyMessageWeatherResponse;
import com.weather.service.WeatherServiceImpl;
import com.github.fedy2.weather.data.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.Locale;

@Controller
public class Controller {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeatherService<Channel> yahooService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "redirect:/forecast/lincoln";
    }

    @RequestMapping(value = "/forecast/{city}", method = RequestMethod.GET)
    public String getForecast(Model model, @PathVariable("city") String city) throws Exception {

        Channel yahooResponse = yahooService.getForecast(city);
        model.addAttribute("cityKey", city);
        model.addAttribute("currentWeather", yahooResponse.getItem().getCondition());
        model.addAttribute("forecasts", yahooResponse.getItem().getForecasts());

        return ResponseEntity.ok(weatherService.getDailytForecast(city));

    }

    @GetMapping("/faq")
    public String faq() {
        return "FAQ";
    }

    @GetMapping("/singlesource")
    public String singleSource() {
        return "singlesource";
    }

    @GetMapping("/history")
    public String history() {
        return "history";
    }
    
    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e){
        return Pages.ERROR;
    }

}
