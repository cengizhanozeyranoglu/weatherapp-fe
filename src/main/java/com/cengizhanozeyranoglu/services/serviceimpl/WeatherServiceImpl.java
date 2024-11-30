package com.cengizhanozeyranoglu.services.serviceimpl;

import com.cengizhanozeyranoglu.configuration.GlobalProperties;
import com.cengizhanozeyranoglu.exception.BaseException;
import com.cengizhanozeyranoglu.exception.ErrorMessage;
import com.cengizhanozeyranoglu.exception.MessageType;
import com.cengizhanozeyranoglu.model.GeoResponse;
import com.cengizhanozeyranoglu.model.WeatherApiResponse;
import com.cengizhanozeyranoglu.services.IGeoService;
import com.cengizhanozeyranoglu.services.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl extends GlobalProperties implements IWeatherService {


    @Autowired
    private IGeoService geoService;


    @Override
    public WeatherApiResponse getWeather(String city) {
        GeoResponse geoResponse = geoService.getGeoInfo(city);
        double Latitude = geoResponse.getResults().get(0).getLat();
        double Longitude = geoResponse.getResults().get(0).getLon();


        String rootUrl = getWeatherEndpoint();
        String endPoint = rootUrl + "?latitude=" + Latitude + "&longitude=" + Longitude + "&hourly=temperature_2m";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<WeatherApiResponse> response = restTemplate.exchange(endPoint, HttpMethod.GET, null, WeatherApiResponse.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
        } catch (Exception e) {
            e.getMessage();
        }
        throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION, ""));
    }
}


