package com.marangoni.purchasingproducer.request;

import java.io.Serializable;
import java.math.BigDecimal;

public record Payment(
        String method,
        BigDecimal amount,
        String status
)implements Serializable {}