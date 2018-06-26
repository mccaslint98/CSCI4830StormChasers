package com.weather.domain;

import lombok.Data;

@Data
public class Sys {

    private int type;

    private Float message;

    private String country;

    private Long sunrise;

    private Long sunset;

}
