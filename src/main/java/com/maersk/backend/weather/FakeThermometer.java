package com.maersk.backend.weather;

import org.springframework.stereotype.Component;


public class FakeThermometer implements Thermometer{

    private int currentTemperature = 21;

    @Override
    public int measure() { return currentTemperature++; }

}
