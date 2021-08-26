package com.jj.greetingservice.controller;

import com.jj.greetingservice.config.GreetingConfig;
import com.jj.greetingservice.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingConfig greetingConfig;

    @GetMapping
    public Greeting greeting() {
        return new Greeting(counter.incrementAndGet(),
                String.format("%s, %s", greetingConfig.getGreeting(), greetingConfig.getDefaultValue()));
    }
}
