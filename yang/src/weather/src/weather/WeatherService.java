package weather;

import at.klinger.domain.owm.OWMForecastResponse;
import at.klinger.service.IWeatherService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

@Service
public class WeatherService implements Service<Response> {

    private UriComponentsBuilder urlbuilder;

    @PostConstruct
    protected void init() {

        urlbuilder = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("api.openweathermap.org")
                .path("/data/2.5/forecast")
                .queryParam("city","Lincoln")
                .queryParam("mode", "json")
                .queryParam("units", "metric")
                .queryParam("appid", "32604cc8b2080d042080972b59242e1b");
           
    }


    @Override
    public Response getForecast(String city) {
        String url = urlbuilder.replaceQueryParam("q", city).build().toUriString();
        return new RestTemplate().getForObject(url, Response.class);
    }
}
