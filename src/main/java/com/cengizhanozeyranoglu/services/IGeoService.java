package com.cengizhanozeyranoglu.services;

import com.cengizhanozeyranoglu.model.GeoResponse;

import java.util.Map;

public interface IGeoService {

    public GeoResponse getGeoInfo(String city);
}
