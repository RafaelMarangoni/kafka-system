package com.marangoni.purchasingproducer.service;

import com.marangoni.purchasingproducer.entity.OrderEntity;
import com.marangoni.purchasingproducer.repository.OrderRepositoryCustom;
import com.marangoni.purchasingproducer.response.OrderResponse;
import com.marangoni.purchasingproducer.services.impl.OrderServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OrderServiceImplTest {

    @Mock
    private OrderRepositoryCustom orderRepositoryCustom;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetOrder() {
        // Arrange
        String itemName = "item1";
        String status = "NEW";
        String paymentStatus = "PENDING";
        String seller = "seller1";

        List<OrderEntity> mockOrders = createMockOrders();
        when(orderRepositoryCustom.findByParams(itemName, paymentStatus, status, seller)).thenReturn(mockOrders);

        List<OrderResponse> result = orderService.getOrder(itemName, status, paymentStatus, seller);

        assertEquals(mockOrders.size(), result.size());

    }

    private List<OrderEntity> createMockOrders() {
        OrderEntity orderMock = new OrderEntity();
        orderMock.setOrderId("Mock");
        orderMock.setCreatedAt(LocalDateTime.now());
        orderMock.setUpdatedAt(LocalDateTime.now());
        orderMock.setStatus("NEW");
        List<OrderEntity> orderEntityList = new ArrayList<>();
        orderEntityList.add(orderMock);

        return orderEntityList;

    }
}
