package com.example.finalapp.service.kafka;

import com.example.finalapp.entity.DocumentEntity;
import com.example.finalapp.repository.DocumentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class KafkaProducerService {

    private KafkaTemplate<String, DocumentEntity> kafkaTemplate;
    private String topic;

    /**
     * Defauld kafka producer service
     * @param kafkaTemplate
     * @param topic
     */
    public KafkaProducerService(KafkaTemplate<String, DocumentEntity> kafkaTemplate,
                                @Value(value = "documents") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    /**
     * Method for sending messages in kafka service
     * @param document - document to send
     * @throws ListenerExecutionFailedException - wrong type of kafka message exeption
     */
    public void sendDocument(DocumentEntity document) throws ListenerExecutionFailedException {
        kafkaTemplate.send(topic, document);
        log.error("Error message of KAFKA", new ListenerExecutionFailedException("WRONG KAFKA MESSAGE"));
    }
}
