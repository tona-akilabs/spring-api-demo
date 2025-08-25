package com.example.spring_api_demo.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.util.TimeZone;

@Component
public class TimezoneResolver {
    public TimeZone resolve(HttpServletRequest request) {
        // 1. Try query param ?tz=
        String tzParam = request.getParameter("tz");
        if (tzParam != null && !tzParam.isBlank()) {
            return TimeZone.getTimeZone(tzParam);
        }

        // 2. Try custom header X-Timezone
        String tzHeader = request.getHeader("X-Timezone");
        if (tzHeader != null && !tzHeader.isBlank()) {
            return TimeZone.getTimeZone(tzHeader);
        }

        // 3. (Optional) Fallback: Accept-Language → guess timezone by region
        String langHeader = request.getHeader("Accept-Language");
        if (langHeader != null && langHeader.contains("en-US")) {
            return TimeZone.getTimeZone("America/New_York");
        }

        // 4. Default UTC
        return TimeZone.getTimeZone("UTC");
    }
}
