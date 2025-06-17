package br.com.microservices.orchestrated.orderservice.core.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "event")
public class Event {

    @Id
    private String id;
    //@JsonProperty("transaction_id")
    private String transactionId;
    //@JsonProperty("order_id")
    private String orderId;
    //@JsonProperty("payload")
    private Order payload;
    //@JsonProperty("source")
    private String source;
    //@JsonProperty("status")
    private String status;
    //@JsonProperty("event_history")
    private List<History> eventHistory;
    //@JsonProperty("created_at")
    private LocalDateTime createdAt;

}
