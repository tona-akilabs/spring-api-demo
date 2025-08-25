package com.example.spring_api_demo.controller;

import com.example.spring_api_demo.config.TimezoneResolver;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/time")
public class TimeController {
    private final TimezoneResolver timezoneResolver;

    public TimeController(TimezoneResolver timezoneResolver) {
        this.timezoneResolver = timezoneResolver;
    }

    @GetMapping("/now")
    public String getNow(HttpServletRequest request) {
        // Resolve timezone
        ZoneId zoneId = timezoneResolver.resolve(request).toZoneId();

        // Convert UTC → User Zone
        ZonedDateTime userTime = Instant.now().atZone(zoneId);

        return "Current time in " + zoneId + " is " + userTime;
    }
}
