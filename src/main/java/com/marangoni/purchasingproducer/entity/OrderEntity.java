package com.marangoni.purchasingproducer.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Document(collection = "order")
public class OrderEntity {

    @Id
    private String id;
    private String orderId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String status;
    private List<ItemEntity> items;
    private String seller;
    private BuyerEntity buyer;
    private AddressEntity shippingAddress;
    private AddressEntity billingAddress;
    private PaymentEntity payment;
}
