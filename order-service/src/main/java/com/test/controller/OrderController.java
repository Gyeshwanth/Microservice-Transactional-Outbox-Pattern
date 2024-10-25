package com.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.common.dto.OrderDto;
import com.test.entity.Order;
import com.test.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) throws JsonProcessingException {

        Order order = orderService.createOrder(orderDto);

        return  new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
