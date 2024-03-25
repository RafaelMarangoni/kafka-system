package com.marangoni.purchasingproducer.repository;

import com.marangoni.purchasingproducer.entity.ItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemsRepository extends MongoRepository<ItemEntity,String> {
}
