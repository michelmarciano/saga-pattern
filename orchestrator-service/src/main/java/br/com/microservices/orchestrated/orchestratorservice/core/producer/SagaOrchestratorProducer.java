package br.com.microservices.orchestrated.orchestratorservice.core.producer;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class SagaOrchestratorProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String payload, String topic) {
        try {
            log.info("Sending message to Kafka topic: {} with data {}", topic, payload);
            kafkaTemplate.send(topic, payload).get();
            log.info("Message sent successfully to Kafka topic: {}", topic);
        }catch (Exception e) {
            log.error("Error sending message to Kafka topic {} with data {}: error {}", topic, payload, e.getMessage());
            throw new RuntimeException("Failed to send message to Kafka topic", e);
        }
    }

}
