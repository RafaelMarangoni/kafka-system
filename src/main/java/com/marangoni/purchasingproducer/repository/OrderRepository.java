package com.marangoni.purchasingproducer.repository;

import com.marangoni.purchasingproducer.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {

    Optional<OrderEntity> findByOrderId(String orderId);
}

