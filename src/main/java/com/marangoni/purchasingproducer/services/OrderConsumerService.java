package com.marangoni.purchasingproducer.services;

import com.marangoni.purchasingproducer.request.OrderRequest;

public interface OrderConsumerService {

    void orderConsumer(OrderRequest orderRequest);
}
