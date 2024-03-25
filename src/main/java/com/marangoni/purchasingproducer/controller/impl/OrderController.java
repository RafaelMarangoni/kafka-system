package com.marangoni.purchasingproducer.controller.impl;

import com.marangoni.purchasingproducer.controller.OrdersController;
import com.marangoni.purchasingproducer.response.OrderResponse;
import com.marangoni.purchasingproducer.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController implements OrdersController {

    private final OrderService orderService;

    @Override
    public ResponseEntity<List<OrderResponse>> getOrders(String item, String status, String statusPayment, String seller) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(orderService.getOrder(item,status,statusPayment, seller));
    }
}
