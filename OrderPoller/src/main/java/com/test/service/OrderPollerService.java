package com.test.service;

import com.test.entity.Outbox;

import com.test.publish.OutboxProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.test.repsitory.OutboxRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@EnableScheduling
public class OrderPollerService {

    private final OutboxRepository outboxRepository;

    private final OutboxProducer outboxProducer;

    @Scheduled(fixedRate = 60000)
    public void pollOutboxMessagesAndPublish() {

        List<Outbox> unProcessedMessages = outboxRepository.findByProcessedFalse();

        log.info("UnProcessedMessages count {}",unProcessedMessages.size());

      unProcessedMessages.forEach(outbox->{
          try{
           outboxProducer.publishMessage(outbox.getPayload());
           outbox.setProcessed(true);
           outboxRepository.save(outbox);
          }
          catch (Exception e) {
              log.error(e.getMessage());
          }
      });
    }

}
