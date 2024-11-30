package com.cengizhanozeyranoglu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeoApiResult {

    @JsonProperty("name")
    private String cityName;

    @JsonProperty("latitude")
    private double lat;

    @JsonProperty("longitude")
    private double lon;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("timezone")
    private String timeZone;

    @JsonProperty("population")
    private String population;


}
