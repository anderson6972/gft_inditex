package com.inditex.gft.integracion.application.service;

import com.inditex.gft.application.port.out.PriceRepository;
import com.inditex.gft.application.service.PriceQueryService;
import com.inditex.gft.domain.exception.PriceNotFoundException;
import com.inditex.gft.domain.model.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@Tag("integracion")
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PriceQueryServiceIntegrationTest {

    @Autowired
    private PriceQueryService priceQueryService;

    @Mock
    private PriceRepository priceRepository;

    private final LocalDateTime startDate = LocalDateTime.parse("2020-06-14 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    private final LocalDateTime endDate = LocalDateTime.parse("2020-12-31 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    private final Long productId = 99999L; // ID de producto que no existe
    private final Long brandId = 99999L;   // ID de brand que no existe

    @Test
    @DisplayName("Test de integracion para la clase PriceQueryService")
    void testQueryPrice() {
        // 1. Preparar los datos de prueba
        Price expectedPrice = new Price(35455L, 1L, 1, startDate, endDate, 35.50);

        // 2. Ejecutar el método queryPrice
        Price result = priceQueryService.queryPrice(35455L, 1L, "2020-06-14 10:00:00");

        // 3. Verificar los resultados
        assertNotNull(result);
        assertEquals(expectedPrice.getProductId(), result.getProductId());
        assertEquals(expectedPrice.getBrandId(), result.getBrandId());
        assertEquals(expectedPrice.getPriceList(), result.getPriceList());
        assertEquals(expectedPrice.getStartDate(), result.getStartDate());
        assertEquals(expectedPrice.getEndDate(), result.getEndDate());
        assertEquals(expectedPrice.getPrice(), result.getPrice());
    }

    @Test
    @DisplayName("Test de integracion para la clase PriceQueryService cuando no se encuentra un precio")
    void testQueryPriceNotFound() {
        // 1. Ejecutar el método queryPrice con parámetros que no existan en la base de datos
        String applicationDate = "2025-02-13 10:00:00"; // Fecha en la que no hay precios

        // 2. Verificar que se lanza la excepción PriceNotFoundException
        assertThrows(PriceNotFoundException.class, () -> {
            priceQueryService.queryPrice(productId, brandId, applicationDate);
        });
    }

    @Test
    @DisplayName("Test de integracion para la clase PriceQueryService cuando la fecha no tiene un formato correcto")
    void testQueryIllegalArgumentException() {
        // 1. Verificar que se lanza la excepción IllegalArgumentException por fecha nula
        assertThrows(IllegalArgumentException.class, () -> {
            priceQueryService.queryPrice(productId, brandId, null);
        });

        // 2. Verificar que se lanza la excepción IllegalArgumentException por fecha con un mal formato
        assertThrows(IllegalArgumentException.class, () -> {
            priceQueryService.queryPrice(productId, brandId, "20-02-2024 10:00:00");
        });
    }
}