package com.example.spring_api_demo.helper;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class CurrencySerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        gen.writeString(currencyFormat.format(value));
    }
}
