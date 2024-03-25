package com.marangoni.purchasingproducer.request;

import java.io.Serializable;
import java.math.BigDecimal;

public record Item(
        String itemId,
        String sku,
        String name,
        String description,
        BigDecimal price,
        String url
) implements Serializable {}
