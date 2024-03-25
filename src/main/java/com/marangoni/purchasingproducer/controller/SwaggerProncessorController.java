package com.marangoni.purchasingproducer.controller;

import com.marangoni.purchasingproducer.request.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface SwaggerProncessorController {

    @PostMapping
    ResponseEntity<?> payment(@RequestBody OrderRequest request);
}
