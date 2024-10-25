package com.test.common.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.entity.Order;
import com.test.entity.Outbox;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OutBoxMapper {

    public Outbox orderToOutBox(Order order) throws JsonProcessingException {
        return Outbox.builder()
                .aggregateId(order.getId().toString())
                .payload(new ObjectMapper().writeValueAsString(order))
                .createdAt(new Date())
                .processed(false)
                .build();
    }
}
