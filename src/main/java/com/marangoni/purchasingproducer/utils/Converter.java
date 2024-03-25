package com.marangoni.purchasingproducer.utils;

import com.marangoni.purchasingproducer.entity.*;
import com.marangoni.purchasingproducer.request.*;
import com.marangoni.purchasingproducer.response.OrderResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.marangoni.purchasingproducer.enums.MethodPaymentEnum.getInstanceFromMethodStatus;
import static com.marangoni.purchasingproducer.enums.PaymentEnum.getInstanceFromPaymentStatus;
import static com.marangoni.purchasingproducer.enums.StatusEnum.getInstanceFromStatus;

@Component
public class Converter {

    public static OrderEntity fromOrderRequest(OrderRequest orderRequest) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderRequest.orderId());
        orderEntity.setCreatedAt(LocalDateTime.now());
        orderEntity.setUpdatedAt(orderRequest.updatedAt());
        orderEntity.setStatus(getInstanceFromStatus(orderRequest.status()).name());
        orderEntity.setItems(orderRequest.items().stream()
                .map(Converter::fromItemRequest)
                .collect(Collectors.toList()));
        orderEntity.setSeller(orderRequest.seller());
        orderEntity.setBuyer(Converter.fromBuyerRequest(orderRequest.buyer()));
        orderEntity.setShippingAddress(Converter.fromAddressRequest(orderRequest.shippingAddress()));
        orderEntity.setBillingAddress(Converter.fromAddressRequest(orderRequest.billingAddress()));
        orderEntity.setPayment(Converter.fromPaymentRequest(orderRequest.payment()));
        return orderEntity;
    }

    public static BuyerEntity fromBuyerRequest(Buyer buyerRequest) {
        BuyerEntity buyerEntity = new BuyerEntity();
        buyerEntity.setId(buyerRequest.id());
        buyerEntity.setName(buyerRequest.name());
        buyerEntity.setEmail(buyerEntity.getEmail());
        // outros campos
        return buyerEntity;
    }

    public static AddressEntity fromAddressRequest(Address addressRequest) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setPostalCode(addressRequest.postalCode());
        addressEntity.setStreetName(addressRequest.streetName());
        addressEntity.setNumber(addressRequest.number());
        addressEntity.setAdditionalInfo(addressRequest.additionalInfo());
        return addressEntity;
    }

    public static PaymentEntity fromPaymentRequest(Payment paymentRequest) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setMethod(getInstanceFromMethodStatus(paymentRequest.method()).name());
        paymentEntity.setAmount(paymentRequest.amount());
        paymentEntity.setStatus(getInstanceFromPaymentStatus(paymentRequest.status()).name());

        return paymentEntity;
    }

    public static ItemEntity fromItemRequest(Item itemRequest) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setItemId(itemRequest.itemId());
        itemEntity.setSku(itemRequest.sku());
        itemEntity.setName(itemRequest.name());
        itemEntity.setDescription(itemRequest.description());
        itemEntity.setPrice(itemRequest.price());
        itemEntity.setUrl(itemRequest.url());
        // outros campos
        return itemEntity;
    }

    public static List<ItemEntity> fromItemRequestList(List<Item> itemRequestList) {
        return itemRequestList.stream()
                .map(Converter::fromItemRequest)
                .collect(Collectors.toList());
    }

    public static List<OrderResponse> fromOrderEntityList(List<OrderEntity> orderEntityList) {
        if (orderEntityList == null) {
            return null;
        }
        return orderEntityList.stream()
                .map(Converter::fromOrderEntity)
                .collect(Collectors.toList());
    }

    public static OrderResponse fromOrderEntity(OrderEntity orderEntity) {
        if (orderEntity == null) {
            return null;
        }
        return new OrderResponse(
                orderEntity.getOrderId(),
                orderEntity.getCreatedAt(),
                orderEntity.getUpdatedAt(),
                orderEntity.getStatus(),
                fromItemEntityList(orderEntity.getItems()),
                orderEntity.getSeller(),
                fromBuyerEntity(orderEntity.getBuyer()),
                fromAddressEntity(orderEntity.getShippingAddress()),
                fromAddressEntity(orderEntity.getBillingAddress()),
                fromPaymentEntity(orderEntity.getPayment())
        );
    }

    public static Buyer fromBuyerEntity(BuyerEntity buyerEntity) {
        if (buyerEntity == null) {
            return null;
        }
        return new Buyer(buyerEntity.getId(), buyerEntity.getName(), buyerEntity.getEmail());
    }

    public static Address fromAddressEntity(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        return new Address(addressEntity.getPostalCode(), addressEntity.getStreetName(), addressEntity.getNumber(), addressEntity.getAdditionalInfo());
    }

    public static Payment fromPaymentEntity(PaymentEntity paymentEntity) {
        if (paymentEntity == null) {
            return null;
        }
        return new Payment(paymentEntity.getMethod(), paymentEntity.getAmount(), paymentEntity.getStatus());
    }

    public static Item fromItemEntity(ItemEntity itemEntity) {
        if (itemEntity == null) {
            return null;
        }
        return new Item(itemEntity.getItemId(), itemEntity.getSku(), itemEntity.getName(), itemEntity.getDescription(), itemEntity.getPrice(), itemEntity.getUrl());
    }

    public static List<Item> fromItemEntityList(List<ItemEntity> itemEntityList) {
        if (itemEntityList == null) {
            return null;
        }
        return itemEntityList.stream()
                .map(Converter::fromItemEntity)
                .collect(Collectors.toList());
    }


}
