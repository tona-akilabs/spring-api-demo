package com.example.spring_api_demo.service;

import com.example.spring_api_demo.request.ProductRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ProductService {
    public String createProduct(@Valid ProductRequest productRequest) {
        String name = productRequest.name();
        Double price = productRequest.price();
        return "Product created: " + name + " with price: " + price;
    }
}
