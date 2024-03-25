package com.marangoni.purchasingproducer.response;

import com.marangoni.purchasingproducer.request.Address;
import com.marangoni.purchasingproducer.request.Buyer;
import com.marangoni.purchasingproducer.request.Item;
import com.marangoni.purchasingproducer.request.Payment;

import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(

        String orderId,

        LocalDateTime createdAt,

        LocalDateTime updatedAt,

        String status,

        List<Item> items,

        String seller,

        Buyer buyer,
        Address shippingAddress,
        Address billingAddress,

        Payment payment
) {
}
