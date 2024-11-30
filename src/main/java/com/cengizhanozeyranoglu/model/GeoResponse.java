package com.cengizhanozeyranoglu.model;

import lombok.Data;
import java.util.List;


@Data
public class GeoResponse {

    private List<GeoApiResult> results;
}
