package com.ecommerce.sportscenter.mapper;

import com.ecommerce.sportscenter.entity.OrderAggregate.Order;
import com.ecommerce.sportscenter.entity.OrderAggregate.OrderStatus;
import com.ecommerce.sportscenter.entity.OrderAggregate.ShippingAddress;
import com.ecommerce.sportscenter.model.OrderResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapperTest {

    private final OrderMapper mapper = OrderMapper.INSTANCE;

    @Test
    void shouldMapExistingOrderFieldsWithoutOverridingStatusAndDate() {
        LocalDateTime orderDate = LocalDateTime.of(2024, 1, 15, 10, 30, 0);
        Order order = Order.builder()
                .id(42)
                .basketId("basket-99")
                .shippingAddress(new ShippingAddress("Jane Doe", "1 Main St", "Apt 2", "London", "ENG", "SW1A 1AA", "UK"))
                .orderDate(orderDate)
                .subTotal(125.50)
                .deliveryFee(15L)
                .orderStatus(OrderStatus.PaymentReceived)
                .build();

        OrderResponse response = mapper.OrderToOrderResponse(order);

        assertEquals(order.getId(), response.getId());
        assertEquals(order.getBasketId(), response.getBasketId());
        assertEquals(order.getShippingAddress(), response.getShippingAddress());
        assertEquals(order.getOrderDate(), response.getOrderDate());
        assertEquals(order.getOrderStatus(), response.getOrderStatus());
        assertEquals(140.5, response.getTotal());
    }
}
