package com.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.common.dto.OrderDto;
import com.test.common.mapper.OrderMapper;
import com.test.common.mapper.OutBoxMapper;
import com.test.entity.Order;
import com.test.entity.Outbox;
import com.test.repsitory.OrderRepository;
import com.test.repsitory.OutboxRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OutboxRepository outboxRepository;
    private final OrderMapper orderMapper;
    private final OutBoxMapper boxMapper;

    @Transactional
    public Order createOrder(OrderDto orderDto) throws JsonProcessingException {

        Order order = orderMapper.orderdtoToOrder(orderDto);
        order = orderRepository.save(order);


        Outbox outbox = boxMapper.orderToOutBox(order);
         outboxRepository.save(outbox);

        return order;
    }

}
