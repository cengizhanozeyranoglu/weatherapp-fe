package com.cengizhanozeyranoglu.controller.controllerimpl;

import com.cengizhanozeyranoglu.controller.IRestWeatherController;
import com.cengizhanozeyranoglu.controller.RestBaseController;
import com.cengizhanozeyranoglu.controller.RootEntity;
import com.cengizhanozeyranoglu.model.WeatherApiResponse;
import com.cengizhanozeyranoglu.services.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest/api")
public class IRestWeatherControllerImpl extends RestBaseController implements IRestWeatherController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/weather")
    @Override
    public RootEntity<WeatherApiResponse> getWeather(@RequestParam("city") String city) {
        return ok(weatherService.getWeather(city));
    }
}
