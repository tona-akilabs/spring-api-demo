package com.example.spring_api_demo.controller;

import com.example.spring_api_demo.request.ProductRequest;
import com.example.spring_api_demo.response.Product;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<Product> getProduct() {
        Product product = new Product("iPhone", BigDecimal.valueOf(1200.00));
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Product product = new Product(productRequest.name(), BigDecimal.valueOf(productRequest.price()));
        return ResponseEntity.ok(product);
    }
}
