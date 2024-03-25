package com.marangoni.purchasingproducer.repository;

import com.marangoni.purchasingproducer.entity.BuyerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuyerRepository extends MongoRepository<BuyerEntity,String> {
}
