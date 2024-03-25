package com.marangoni.purchasingproducer.services;

import com.marangoni.purchasingproducer.response.OrderResponse;

import java.util.List;

public interface OrderService {

    List<OrderResponse> getOrder(String param, String status, String statusPayment, String seller);
}
