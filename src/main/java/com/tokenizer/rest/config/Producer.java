package com.tokenizer.rest.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tokenizer.rest.request.AuthRequest;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

public class Producer {
    public void createProducerAndSendMessage(AuthRequest authRequest) throws JsonProcessingException {
        final Map map = new HashMap<>();
        map.put("bootstrap.servers", "localhost:9092");
        map.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        map.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kpr = new KafkaProducer<String, String>(map);
        ObjectMapper objectMapper = new ObjectMapper();
        kpr.send(new ProducerRecord("card-info", objectMapper.writeValueAsString(authRequest)));
        kpr.close();
    }
}
