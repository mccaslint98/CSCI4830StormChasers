/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.weather;

import java.util.Map;
import org.springframework.stereotype.Controller;
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
//    @RequestMapping("/#faq")
//    public String faq(Map<String, Object> model) {
//        model.put("message", "FAQ Page");
//        return "FAQ.html";
//    }
    
    
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
    
    @RequestMapping("/")
    public String welcome(Map<String, Object> model){
        model.put("message", "Hello World");
        return "welcome";
    }
}
