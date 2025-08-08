package com.example.spring_api_demo.controller.version;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @GetMapping(value = "/param", params = "version=1")
    public ResponseEntity<?> getParamV1() {
        // This method will handle project creation logic for version 1
        return ResponseEntity.ok("Project created successfully in version 1");
    }

    @GetMapping(value = "/param", params = "version=2")
    public ResponseEntity<?> getParamV2() {
        // This method will handle project creation logic for version 2
        return ResponseEntity.ok("Project created successfully in version 2");
    }

    @GetMapping(value = "/header", headers = "X-API-VERSION=1")
    public ResponseEntity<?> getHeaderV1() {
        // This method will handle project creation logic for version 1
        return ResponseEntity.ok("Project created successfully in version 1");
    }

    @GetMapping(value = "/header", headers = "X-API-VERSION=2")
    public ResponseEntity<?> getHeaderV2() {
        // This method will handle project creation logic for version 2
        return ResponseEntity.ok("Project created successfully in version 2");
    }

    @GetMapping(value = "/produces", produces = "application/vnd.api.v1+json")
    public ResponseEntity<?> getProducesV1() {
        // This method will handle project creation logic for version 1
        return ResponseEntity.ok("Project created successfully in version 1");
    }

    @GetMapping(value = "/produces", produces = "application/vnd.api.v2+json")
    public ResponseEntity<?> getProducesV2() {
        // This method will handle project creation logic for version 2
        return ResponseEntity.ok("Project created successfully in version 2");
    }

    @GetMapping(value = "/consumes", consumes = "application/vnd.api.v1+json")
    public ResponseEntity<?> getConsumesV1() {
        // This method will handle project creation logic for version 1
        return ResponseEntity.ok("Project created successfully in version 1");
    }

    @GetMapping(value = "/consumes", consumes = "application/vnd.api.v2+json")
    public ResponseEntity<?> getConsumesV2() {
        // This method will handle project creation logic for version 2
        return ResponseEntity.ok("Project created successfully in version 2");
    }


}
