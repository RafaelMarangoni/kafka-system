package com.marangoni.purchasingproducer.request;

import java.io.Serializable;

public record Buyer(
        String id,
        String name,
        String email
)implements Serializable {}
