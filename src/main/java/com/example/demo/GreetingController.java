package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    // initialising your variables you plan to use
    private static final String template = "Hello there %s!";
    private final AtomicLong counter = new AtomicLong();

    private static final String forecast = "The weather for today is %s";


    // to fire up this function, endpoint must be
    // localhost:8080/greeting
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Huncho Jack") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/weather")
    public Weather getWeatherObject(
            @RequestParam(value = "weather", defaultValue = "very nice") String weather,
            @RequestParam(value = "hotWeather", defaultValue = "Very hot today boys and girls") String hotWeather,
            @RequestParam(value = "coldWeather", defaultValue = "Ice cold for today lads") String coldWeather
    ) {
        return new Weather(counter.incrementAndGet(), String.format(forecast, weather));
    }


}
