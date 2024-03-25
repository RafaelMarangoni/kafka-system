package com.marangoni.purchasingproducer.listener;


import com.marangoni.purchasingproducer.request.OrderRequest;
import com.marangoni.purchasingproducer.services.OrderConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@RequiredArgsConstructor
@Log4j2
@Component
public class ProcessorConsumerListener {

    private final OrderConsumerService orderConsumerService;

    @SneakyThrows
    @KafkaListener(groupId = "group-1", topics = "processor-order-topic", containerFactory = "processorConteinerFactory")
    public void processorSale(@Payload OrderRequest request){
        log.info("receiving purchase processing : {}", request);
        sleep(2000);
        orderConsumerService.orderConsumer(request);
    }
}
