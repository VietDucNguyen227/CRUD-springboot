package com.example.demodilam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/hello")

    //https://localhost:8080/hello?name=phuc
    public String greeting(@RequestParam(value = "name", defaultValue = "world") String name){
        return "Hello " + name;
    }
}
