package com.inditex.gft.domain.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {

    @Test
    void testPriceCreation() {
        LocalDateTime startDate = LocalDateTime.of(2020, 6, 14, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2020, 12, 31, 23, 59);
        Price price = new Price(1L, 35455L, 1, startDate, endDate, 35.50);

        assertEquals(35455L, price.getBrandId());
        assertEquals(1L, price.getProductId());
        assertEquals(35.50, price.getPrice());
    }
}
