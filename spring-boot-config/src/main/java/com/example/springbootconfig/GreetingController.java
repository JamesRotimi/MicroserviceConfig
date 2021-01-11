package com.example.springbootconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Value("${my.greeting}")
    private String greetingMessage;

//    @Value("${some static message}")
//    private String staticMessage;

    @Value("${my.list.values}")
    private List <String> listValues;

    @Autowired
    private DbSettings dbSettings;

    public GreetingController() {

    }

    @GetMapping("/greeting")
    public String greeting() {
        return dbSettings.getConnection() + dbSettings.getHost();
    }
}
