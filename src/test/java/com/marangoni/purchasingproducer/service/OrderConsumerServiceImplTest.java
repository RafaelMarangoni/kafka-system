package com.marangoni.purchasingproducer.service;

import com.marangoni.purchasingproducer.entity.*;
import com.marangoni.purchasingproducer.repository.*;
import com.marangoni.purchasingproducer.request.*;
import com.marangoni.purchasingproducer.services.impl.OrderConsumerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderConsumerServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private BuyerRepository buyerRepository;

    @Mock
    private ItemsRepository itemsRepository;

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private OrderConsumerServiceImpl orderConsumerService;

    @Test
    public void testOrderConsumer_OrderExists_StatusUpdated() {
        // Arrange
        OrderRequest orderRequest = createOrderRequest();
        OrderEntity existingOrderEntity = createOrderEntity();
        existingOrderEntity.setStatus("NEW");

        when(orderRepository.findByOrderId(orderRequest.orderId())).thenReturn(Optional.of(existingOrderEntity));

        orderConsumerService.orderConsumer(orderRequest);

        verify(orderRepository, times(1)).findByOrderId(orderRequest.orderId());
        verify(orderRepository, times(1)).save(existingOrderEntity);
        verifyNoMoreInteractions(orderRepository);
        verifyNoInteractions(addressRepository, buyerRepository, itemsRepository, paymentRepository);
    }

    @Test
    public void testOrderConsumer_OrderDoesNotExist_NewOrderSaved() {
        // Arrange
        OrderRequest orderRequest = createOrderRequest();

        when(orderRepository.findByOrderId(orderRequest.orderId())).thenReturn(Optional.empty());

        orderConsumerService.orderConsumer(orderRequest);

        verify(orderRepository, times(1)).findByOrderId(orderRequest.orderId());
        verify(orderRepository, times(1)).save(any(OrderEntity.class));
        verify(addressRepository, times(1)).save(any(AddressEntity.class));
        verify(buyerRepository, times(1)).save(any(BuyerEntity.class));
        verify(paymentRepository, times(1)).save(any(PaymentEntity.class));
        verifyNoMoreInteractions(orderRepository, addressRepository, buyerRepository, itemsRepository, paymentRepository);
    }

    private OrderRequest createOrderRequest() {
        List<Item> itemList = new ArrayList<>();
        Buyer buierMock = new Buyer("Mock", "Mock","Mock");
        Address adressMock = new Address("mock","mock","mock","mock");
        Payment paymentMock = new Payment("Mock",new BigDecimal(10),"adressMock");
       return  new OrderRequest("MOCK",LocalDateTime.now(),LocalDateTime.now(),"NEW",itemList,"MOCK",buierMock,adressMock,adressMock,paymentMock);
    }

    private OrderEntity createOrderEntity() {
       OrderEntity orderMock = new OrderEntity();
       orderMock.setOrderId("Mock");
       orderMock.setCreatedAt(LocalDateTime.now());
       orderMock.setUpdatedAt(LocalDateTime.now());
       orderMock.setStatus("NEW");
       return orderMock;
    }
}
