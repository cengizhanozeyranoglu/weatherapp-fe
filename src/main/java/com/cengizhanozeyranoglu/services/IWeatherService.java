package com.cengizhanozeyranoglu.services;

import com.cengizhanozeyranoglu.model.WeatherApiResponse;

public interface IWeatherService {

    public WeatherApiResponse getWeather(String city);
}
