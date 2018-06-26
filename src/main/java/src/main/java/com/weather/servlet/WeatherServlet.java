package src.main.java.com.weather.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import src.main.java.com.weather.dao.WeatherDAO;
import src.main.java.com.weather.view.Weather;

@Controller
public class WeatherServlet extends HttpServlet{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
            doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
        // TODO Auto-generated method stub
        String city = req.getParameter("city");
        String source = req.getParameter("source");
        System.out.println(city);

        WeatherDAO weatherDao = new WeatherDAO();
        ArrayList<Weather> weatherList = weatherDao.getWeather(city,source);
        req.setAttribute("weatherList",weatherList);
        RequestDispatcher rd=req.getRequestDispatcher("daily.jsp");
    rd.forward(req, resp); 
    }
}
