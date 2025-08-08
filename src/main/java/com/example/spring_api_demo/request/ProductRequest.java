package com.example.spring_api_demo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotNull(message = "Price is required")
        @Positive(message = "Price must be greater than 0")
        Double price
) {
}
