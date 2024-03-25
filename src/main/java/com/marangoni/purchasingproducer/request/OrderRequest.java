package com.marangoni.purchasingproducer.request;

import org.springframework.cglib.core.Local;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public record OrderRequest(
        @NotNull
        String orderId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        @NotNull
        String status,
        @NotNull
        List<Item> items,
        @NotNull
        String seller,
        @NotNull
        Buyer buyer,
        Address shippingAddress,
        Address billingAddress,
        @NotNull
        Payment payment
) implements Serializable {}
