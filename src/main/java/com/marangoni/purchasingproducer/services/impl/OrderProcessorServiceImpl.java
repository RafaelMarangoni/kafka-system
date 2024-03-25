package com.marangoni.purchasingproducer.services.impl;

import com.marangoni.purchasingproducer.request.OrderRequest;
import com.marangoni.purchasingproducer.services.OrderProcessorService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@RequiredArgsConstructor
@Service
public class OrderProcessorServiceImpl implements OrderProcessorService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendOrder(OrderRequest orderRequest) {
       log.info("receiving processing {}:", orderRequest);
       Thread.sleep(1000);

       log.info("sending processing{}:", orderRequest);
       kafkaTemplate.send("processor-order-topic", orderRequest);

    }
}
