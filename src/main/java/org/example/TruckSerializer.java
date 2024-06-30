package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class TruckSerializer implements Serializer<Truck> {
    @Override
    public byte[] serialize(String topic, Truck data) {

        ObjectMapper objectMapper=new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(data).getBytes();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
