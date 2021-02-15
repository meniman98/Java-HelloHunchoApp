package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    // initialising your variables you plan to use
    private static final String template = "Hello there %s!";
    private final AtomicLong counter = new AtomicLong();

    // to fire up this function, endpoint must be
    // localhost:8080/greeting
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "" +
            "Huncho Jack") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
}
