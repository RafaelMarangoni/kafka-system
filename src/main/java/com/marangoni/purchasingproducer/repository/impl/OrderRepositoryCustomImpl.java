package com.marangoni.purchasingproducer.repository.impl;

import com.marangoni.purchasingproducer.entity.OrderEntity;
import com.marangoni.purchasingproducer.repository.OrderRepositoryCustom;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryCustomImpl implements OrderRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    public OrderRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<OrderEntity> findByParams(String itemName, String paymentStatus, String status, String seller) {
        Criteria criteria = new Criteria();
        List<Criteria> criteriaList = new ArrayList<>();

        if (seller != null && !seller.isEmpty()) {
            criteriaList.add(Criteria.where("seller").regex(seller, "i"));
        }
        if (itemName != null && !itemName.isEmpty()) {
            criteriaList.add(Criteria.where("items.name").regex(itemName, "i"));
        }
        if (paymentStatus != null && !paymentStatus.isEmpty()) {
            criteriaList.add(Criteria.where("payment.status").is(paymentStatus));
        }
        if (status != null && !status.isEmpty()) {
            criteriaList.add(Criteria.where("status").is(status));
        }

        if (!criteriaList.isEmpty()) {
            criteria.orOperator(criteriaList.toArray(new Criteria[0]));
        }

        Query query = new Query(criteria);

        return mongoTemplate.find(query, OrderEntity.class);
    }
}
