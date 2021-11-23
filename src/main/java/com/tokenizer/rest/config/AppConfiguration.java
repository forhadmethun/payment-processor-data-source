package com.tokenizer.rest.config;

import io.dropwizard.Configuration;

public class AppConfiguration extends Configuration {
    private String bootstrapServer = "localhost:9092";
    private String keySerializer = "org.apache.kafka.common.serialization.StringSerializer";
    private String valueSerializer = "org.apache.kafka.common.serialization.StringSerializer";
    private String topic = "card-info";

    public String getBootstrapServer() {
        return bootstrapServer;
    }

    public AppConfiguration setBootstrapServer(String bootstrapServer) {
        this.bootstrapServer = bootstrapServer;
        return this;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public AppConfiguration setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
        return this;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public AppConfiguration setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public AppConfiguration setTopic(String topic) {
        this.topic = topic;
        return this;
    }
}
