package com.example.spring_api_demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class GreetingController {
    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/greet")
    public String greet(Locale locale) {
        String message = messageSource.getMessage("greeting", null, locale);
        logger.info("Greeting message: {}", message);
        return message;
    }
}
