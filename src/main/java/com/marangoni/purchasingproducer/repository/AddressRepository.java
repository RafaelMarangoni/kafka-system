package com.marangoni.purchasingproducer.repository;

import com.marangoni.purchasingproducer.entity.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<AddressEntity,String> {
}
