package com.cengizhanozeyranoglu.services.serviceimpl;

import com.cengizhanozeyranoglu.configuration.GlobalProperties;
import com.cengizhanozeyranoglu.exception.BaseException;
import com.cengizhanozeyranoglu.exception.ErrorMessage;
import com.cengizhanozeyranoglu.exception.MessageType;
import com.cengizhanozeyranoglu.model.GeoResponse;
import com.cengizhanozeyranoglu.services.IGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GeoServiceImpl implements IGeoService {
    @Autowired
    private GlobalProperties globalProperties;


    @Override
    public GeoResponse getGeoInfo(String city) {

        String rootUrl = globalProperties.getGeoEndpoint();

        String language = "tr";

        String count = "1";

        String format = "json";


        String endPoint = rootUrl + city + "&count=" + count + "&language=" + language + "&format=" + format;


        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<GeoResponse> response = restTemplate.exchange(endPoint, HttpMethod.GET, null, GeoResponse.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();

            }
        } catch (Exception e) {
            e.getMessage();
        }

        throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION, ""));
    }
}
