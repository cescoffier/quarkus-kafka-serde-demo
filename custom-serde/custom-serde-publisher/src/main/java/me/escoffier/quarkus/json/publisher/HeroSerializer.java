package me.escoffier.quarkus.json.publisher;

import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

public class HeroSerializer implements Serializer<Hero> {
    @Override
    public byte[] serialize(String topic, Hero data) {
        return (data.name() + "," + data.picture()).getBytes(StandardCharsets.UTF_8);
    }
}
