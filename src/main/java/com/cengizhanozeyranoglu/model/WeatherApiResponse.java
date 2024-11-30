package com.cengizhanozeyranoglu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherApiResponse {

    private  String latitude;

    private  String longitude;

    private String timezone;

    @JsonProperty("hourly")
    private HourlyTemp hourleytemp;
}
