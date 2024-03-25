package com.marangoni.purchasingproducer.services.impl;

import com.marangoni.purchasingproducer.entity.OrderEntity;
import com.marangoni.purchasingproducer.repository.OrderRepositoryCustom;
import com.marangoni.purchasingproducer.response.OrderResponse;
import com.marangoni.purchasingproducer.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.marangoni.purchasingproducer.utils.Converter.fromOrderEntityList;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepositoryCustom orderRepositoryCustom;

    public List<OrderResponse> getOrder(String itemName, String status, String paymentStatus, String seller) {
        logger.info("Searching orders with itemName={}, paymentStatus={}, status={}", itemName, paymentStatus, status);
        List<OrderEntity> orders = orderRepositoryCustom.findByParams(itemName, paymentStatus, status, seller);
        logger.info("Found {} orders", orders.size());
        return fromOrderEntityList(orders);
    }

}
