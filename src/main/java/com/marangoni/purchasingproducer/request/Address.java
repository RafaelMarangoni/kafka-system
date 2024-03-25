package com.marangoni.purchasingproducer.request;

import java.io.Serializable;

public record Address(
        String postalCode,
        String streetName,
        String number,
        String additionalInfo
)implements Serializable {}
