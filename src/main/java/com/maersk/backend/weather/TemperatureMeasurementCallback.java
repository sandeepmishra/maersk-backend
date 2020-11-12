package com.maersk.backend.weather;

@FunctionalInterface
public interface TemperatureMeasurementCallback {
    void temperatureMeasured(int temperature);
}
