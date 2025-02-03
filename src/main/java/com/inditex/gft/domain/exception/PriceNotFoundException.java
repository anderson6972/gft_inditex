package com.inditex.gft.domain.exception;

/**
 * Excepción lanzada cuando no se encuentra un precio aplicable para los parámetros indicados.
 */
public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(String message) {
        super(message);
    }

}
