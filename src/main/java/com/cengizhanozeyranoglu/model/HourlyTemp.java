package com.cengizhanozeyranoglu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HourlyTemp {

    @JsonProperty("temperature_2m")
    private List<String> temp;
}
