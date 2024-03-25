package com.marangoni.purchasingproducer.exception;

public record ErrorResponse(
        String message,
        Throwable cause
) {
}
