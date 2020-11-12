package com.maersk.backend.weather;


import com.maersk.backend.weather.service.WeatherForecastService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import({WeatherForecastService.class})
public class Config {

    @Bean
    public TemperatureMeasurementCallback callback() {
        return (temperature) -> System.out.println(temperature);
    }

    @Bean
    @Scope("prototype")
    public Thermometer fakeThermometer(){
        return new FakeThermometer();
    }
}
