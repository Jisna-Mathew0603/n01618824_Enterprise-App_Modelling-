package com.example.ServiceProvider.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @GetMapping("/message")
    public String getMessage(@RequestParam(defaultValue = "Client") String name) {
        return "Hello, " + name + "! This response is from Service Provider.";
    }
}