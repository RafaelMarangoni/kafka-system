package com.marangoni.purchasingproducer.repository;

import com.marangoni.purchasingproducer.entity.OrderEntity;

import java.util.List;

public interface OrderRepositoryCustom {
    List<OrderEntity> findByParams(String itemName, String paymentStatus, String status, String seller);
}

