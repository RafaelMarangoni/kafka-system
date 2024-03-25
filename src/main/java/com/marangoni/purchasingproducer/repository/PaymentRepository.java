package com.marangoni.purchasingproducer.repository;

import com.marangoni.purchasingproducer.entity.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentEntity, String> {
}
