package com.cengizhanozeyranoglu.controller;

import com.cengizhanozeyranoglu.model.WeatherApiResponse;

public interface IRestWeatherController {

    public RootEntity<WeatherApiResponse>getWeather(String city);
}
