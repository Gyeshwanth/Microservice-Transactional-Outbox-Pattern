package com.test.kafka.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${order.poller.topic.name}")
    private String topicName;

    @Bean
    public NewTopic orderTopic(){
        return new NewTopic(topicName,3,(short) 1);
    }

}
