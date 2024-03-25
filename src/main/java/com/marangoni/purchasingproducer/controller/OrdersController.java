package com.marangoni.purchasingproducer.controller;

import com.marangoni.purchasingproducer.response.OrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrdersController {

    @GetMapping
    ResponseEntity<List<OrderResponse>> getOrders(@RequestParam(value = "itemName", required = false) String item,
                                                  @RequestParam(value = "status", required = false) String status,
                                                  @RequestParam(value = "statusPayment", required = false) String statusPayment,
                                                  @RequestParam(value = "seller") String seller);
}
