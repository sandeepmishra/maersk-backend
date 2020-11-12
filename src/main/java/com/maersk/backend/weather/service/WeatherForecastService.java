package com.maersk.backend.weather.service;

import com.maersk.backend.weather.Config;
import com.maersk.backend.weather.TemperatureMeasurementCallback;
import com.maersk.backend.weather.Thermometer;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WeatherForecastService {

    private ApplicationContext applicationContext;

    @Autowired
    private TemperatureMeasurementCallback callback;

    @Scheduled(fixedRate = 50)
    public void takeTemperatureMeasurement() {
        AbstractApplicationContext context
                = new AnnotationConfigApplicationContext(Config.class);
        Thermometer thermometer = (Thermometer) context.getBean("fakeThermometer");
        int temperature = thermometer.measure();
        callback.temperatureMeasured(temperature);
        System.out.println("Running through scheduler...");
    }

}
