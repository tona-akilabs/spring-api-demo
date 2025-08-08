package com.example.spring_api_demo.controller;

import com.example.spring_api_demo.response.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<Product> getProduct() {
        Product product = new Product("iPhone", BigDecimal.valueOf(1200.00));
        return ResponseEntity.ok(product);
    }
}
