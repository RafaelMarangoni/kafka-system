package com.marangoni.purchasingproducer.services.impl;

import com.marangoni.purchasingproducer.entity.ItemEntity;
import com.marangoni.purchasingproducer.entity.OrderEntity;
import com.marangoni.purchasingproducer.repository.*;
import com.marangoni.purchasingproducer.request.OrderRequest;
import com.marangoni.purchasingproducer.services.OrderConsumerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.marangoni.purchasingproducer.enums.StatusEnum.getInstanceFromStatus;
import static com.marangoni.purchasingproducer.utils.Converter.*;


@Service
public class OrderConsumerServiceImpl implements OrderConsumerService {

    private final OrderRepository orderRepository;
    private final AddressRepository addressRepository;
    private final BuyerRepository buyerRepository;
    private final ItemsRepository itemsRepository;
    private final PaymentRepository paymentRepository;

    public OrderConsumerServiceImpl(OrderRepository orderRepository, AddressRepository addressRepository, BuyerRepository buyerRepository, ItemsRepository itemsRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.addressRepository = addressRepository;
        this.buyerRepository = buyerRepository;
        this.itemsRepository = itemsRepository;
        this.paymentRepository = paymentRepository;
    }
@Override
public void orderConsumer(OrderRequest orderRequest) {

    var buildListItemsEntity = fromItemRequestList(orderRequest.items());

    Optional<OrderEntity> existingOrder = orderRepository.findByOrderId(orderRequest.orderId());
    if (existingOrder.isPresent()) {
        OrderEntity orderEntity = existingOrder.get();
        orderEntity.setStatus(getInstanceFromStatus(orderRequest.status()).name());
        orderRepository.save(orderEntity);
    } else {

        orderRepository.save(fromOrderRequest(orderRequest));
        addressRepository.save(fromAddressRequest((orderRequest.shippingAddress())));
        buyerRepository.save(fromBuyerRequest(orderRequest.buyer()));
        saveItems(buildListItemsEntity);
        paymentRepository.save(fromPaymentRequest(orderRequest.payment()));
    }
}

    public void saveItems(List<ItemEntity> itemEntities) {
        for (ItemEntity itemEntity : itemEntities) {
            itemsRepository.save(itemEntity);
        }
    }


}
