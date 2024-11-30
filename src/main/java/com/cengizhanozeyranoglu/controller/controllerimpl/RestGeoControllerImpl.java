package com.cengizhanozeyranoglu.controller.controllerimpl;

import com.cengizhanozeyranoglu.controller.IRestGeoController;
import com.cengizhanozeyranoglu.controller.RestBaseController;
import com.cengizhanozeyranoglu.controller.RootEntity;
import com.cengizhanozeyranoglu.model.GeoResponse;
import com.cengizhanozeyranoglu.services.IGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/api")
public class RestGeoControllerImpl extends RestBaseController implements IRestGeoController {

    @Autowired
    private IGeoService geoService;

    @GetMapping("/geo")
    @Override
    public RootEntity<GeoResponse> getGeoInfo(@RequestParam("city") String city) {
        return ok(geoService.getGeoInfo(city));
    }
}
