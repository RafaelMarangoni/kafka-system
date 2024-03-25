package com.marangoni.purchasingproducer.services;

import com.marangoni.purchasingproducer.request.OrderRequest;

public interface OrderProcessorService {

    void sendOrder(OrderRequest orderRequest);
}
