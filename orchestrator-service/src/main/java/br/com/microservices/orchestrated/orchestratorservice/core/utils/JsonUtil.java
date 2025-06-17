package br.com.microservices.orchestrated.orchestratorservice.core.utils;

import br.com.microservices.orchestrated.orchestratorservice.core.dto.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class JsonUtil {

    private final ObjectMapper objectMapper;

    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public Event toEvent(String json) {
        try {
            return objectMapper.readValue(json, Event.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
