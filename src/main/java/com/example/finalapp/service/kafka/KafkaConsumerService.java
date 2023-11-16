package com.example.finalapp.service.kafka;

import com.example.finalapp.entity.DocumentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Component
public class KafkaConsumerService {
    /**
     * Default Kafka Listener
     * @param message - contain Entity of Document
     */
    @KafkaListener(topics = {"documents"})
    public void listen(@Payload DocumentEntity message) {
        log.info("Received message: {}", message);


    }
}
