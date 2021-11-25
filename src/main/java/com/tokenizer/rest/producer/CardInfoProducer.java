package com.tokenizer.rest.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tokenizer.rest.model.AuthModel;
import com.tokenizer.rest.request.AuthRequest;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

import static com.tokenizer.rest.App.properties;
import static com.tokenizer.rest.util.Builders.build;
import static com.tokenizer.rest.util.Constants.TOPIC;

public class CardInfoProducer {

    private static final Logger logger = LoggerFactory.getLogger(CardInfoProducer.class);

    public String createProducerAndSendMessage(AuthRequest authRequest) throws JsonProcessingException {
        KafkaProducer kpr = new KafkaProducer(properties);
        ObjectMapper objectMapper = new ObjectMapper();
        AuthModel authModel = build(authRequest);
        authModel.setTransactionId(getGenerateTransactionId());
        kpr.send(new ProducerRecord(properties.getProperty(TOPIC),
            objectMapper.writeValueAsString(authModel)));
        kpr.close();
        logger.info("Sent message successfully for txId: {}", authModel.getTransactionId());
        return authModel.getTransactionId();
    }

    private String getGenerateTransactionId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
