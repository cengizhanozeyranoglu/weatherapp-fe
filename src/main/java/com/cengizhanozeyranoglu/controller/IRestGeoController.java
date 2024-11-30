package com.cengizhanozeyranoglu.controller;

import com.cengizhanozeyranoglu.model.GeoResponse;


public interface IRestGeoController {

    public RootEntity<GeoResponse> getGeoInfo(String city);

}
