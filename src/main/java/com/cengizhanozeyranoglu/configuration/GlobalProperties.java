package com.cengizhanozeyranoglu.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class GlobalProperties {

    @Value("${geo.endpoint}")
    private String geoEndpoint;


    @Value("${weather.enpoint}")
    private String weatherEndpoint;


}
