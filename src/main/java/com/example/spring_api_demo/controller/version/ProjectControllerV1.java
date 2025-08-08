package com.example.spring_api_demo.controller.version;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectControllerV1 {

    @GetMapping
    public ResponseEntity<?> v1() {
        // This method will handle project creation logic for version 1
        return ResponseEntity.ok("Project created successfully in version 1");
    }
}
