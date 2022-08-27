package me.escoffier.quarkus;

import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;

public class HeroDeserializer implements Deserializer<Hero> {
    @Override
    public Hero deserialize(String topic, byte[] data) {
        String contentAsString = new String(data, StandardCharsets.UTF_8);
        String[] segments = contentAsString.split(",");
        return new Hero(segments[0], segments[1]);
    }
}
