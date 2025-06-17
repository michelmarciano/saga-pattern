package br.com.microservices.orchestrated.orderservice.core.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SagaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic.start-saga}")
    private String startSagaTopic;

    public void sendEvent(String payload) {
        try {
            log.info("Sending message to Kafka topic: {} with data {}", startSagaTopic, payload);
            kafkaTemplate.send(startSagaTopic, payload).get();
            log.info("Message sent successfully to Kafka topic: {}", startSagaTopic);
        }catch (Exception e) {
            log.error("Error sending message to Kafka topic {} with data {}: error {}", startSagaTopic, payload, e.getMessage());
            throw new RuntimeException("Failed to send message to Kafka topic", e);
        }
    }

}
