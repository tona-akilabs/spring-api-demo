package com.example.spring_api_demo.controller;

import com.example.spring_api_demo.request.AccountRegister;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid AccountRegister account) {
        // This method will handle authentication logic
        return ResponseEntity.ok("Register New Account successful");
    }
}
