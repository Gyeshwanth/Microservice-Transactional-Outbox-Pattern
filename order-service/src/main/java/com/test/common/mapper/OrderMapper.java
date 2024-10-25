package com.test.common.mapper;

import com.test.common.dto.OrderDto;

import com.test.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderMapper {

    public Order orderdtoToOrder(OrderDto orderRequestDTO) {
     return Order.builder() .customerId(orderRequestDTO.getCustomerId())
                .name(orderRequestDTO.getName())
                .productType(orderRequestDTO.getProductType())
                .quantity(orderRequestDTO.getQuantity())
                .price(orderRequestDTO.getPrice())
                .orderDate(new Date())
                .build();
    }
}
