package com.marangoni.purchasingproducer.controller.impl;

import com.marangoni.purchasingproducer.controller.ProncessorController;
import com.marangoni.purchasingproducer.request.OrderRequest;
import com.marangoni.purchasingproducer.services.OrderProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/processor-order")
public class ProcessorControllerImpl implements ProncessorController {

    private final OrderProcessorService service;

    @Override
    public ResponseEntity<?> payment(OrderRequest request) {
        service.sendOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
