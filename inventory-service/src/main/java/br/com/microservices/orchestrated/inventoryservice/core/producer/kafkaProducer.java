package br.com.microservices.orchestrated.inventoryservice.core.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class kafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic.orchestrated}")
    private String orchestratedTopic;

    public void sendMessage(String payload) {
        try {
            log.info("Sending message to Kafka topic: {} with data {}", orchestratedTopic, payload);
            kafkaTemplate.send(orchestratedTopic, payload).get();
            log.info("Message sent successfully to Kafka topic: {}", orchestratedTopic);
        }catch (Exception e) {
            log.error("Error sending message to Kafka topic {} with data {}: error {}", orchestratedTopic, payload, e.getMessage());
            throw new RuntimeException("Failed to send message to Kafka topic", e);
        }
    }

}
