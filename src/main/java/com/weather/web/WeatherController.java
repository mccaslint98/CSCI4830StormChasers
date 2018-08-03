/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weather.web;

import com.weather.domain.DailyMessageWeatherResponse;
import com.weather.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author yifan
 */
@Controller
public class WeatherController {

    //private WeatherServlet wServlet = new WeatherServlet();
//    @RequestMapping("/#current")
//    public String home(Map<String, Object> model){
//        model.put("message", "Current");
//        return "Current.html";
//    }
//
//    @PostMapping("/daily")
//    public void daily(Map<String, Object> model, HttpServletRequest req, HttpServletResponse resp)
//    throws ServletException, IOException {
//        model.put("message", "Daily Page");
//
//        String city = req.getParameter("city");
//        String source = req.getParameter("source");
//        System.out.println(city);
//
//        WeatherDAO weatherDao = new WeatherDAO();
//        ArrayList<Weather> weatherList = weatherDao.getWeather(city,source);
//        req.setAttribute("weatherList",weatherList);
//        RequestDispatcher rd=req.getRequestDispatcher("daily.jsp");
//        rd.forward(req, resp);
//
//    }
    @Autowired
    WeatherServiceImpl weatherService;

    @RequestMapping("/daily/{city}")
    public ResponseEntity<DailyMessageWeatherResponse> getDaily(@PathVariable String city) {
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

    @GetMapping("/sourcecomparison")
    public String sourceComparison() {
        return "/sourcecomparison";
    }

    @GetMapping("/history")
    public String history() {
        return "/history";
    }

}
