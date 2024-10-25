package com.test.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OutboxConsumer {

    @KafkaListener(topics = "outbox-event",groupId = "yeshu")
    public void consume(String payload){
        log.info("Event consumed {} ",payload);
    }
}
