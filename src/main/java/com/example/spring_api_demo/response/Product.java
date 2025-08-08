package com.example.spring_api_demo.response;

import com.example.spring_api_demo.helper.CurrencySerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal price;

    public Product() {}
    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonSerialize(using = CurrencySerializer.class)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
