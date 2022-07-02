package com.crossoriginspringboot.controllers;

import com.crossoriginspringboot.models.Greeting;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:80", "http://example.com"})
public class HelloController {
    private static final String template1 = "Hello, %s!";
    private static final String template2 = "Hi, %s!";

    private final AtomicLong counter = new AtomicLong();
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/hello")
    public Greeting hello(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template1, name));
    }

    @GetMapping("/hi")
    public Greeting hi(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template2, name));
    }
}
