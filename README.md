# Quarkus - Kafka Serialization and Deserialization Demo

This repository contains three variants of the same system:

1. A variant using JSON to encode the Kafka records
2. A variant using Avro to encode the Kafka records
3. A variant using a custom (and dumb) protocol to encode the Kafka records

## The system

The system is composed of two applications:

1. A publisher writing _Heroes_ into the `heroes` Kafka topic.
2. A consumer consuming these _Heroes_ and sending them to a web page.

## Building

Run `mvn install` from the root.

## Running the demo

Select a variant and open two terminals.
In the first one, go to the publisher module of the variant and run `mvn quarkus:dev`.
In the second one, go to the consumer module of the variant and run `mvn quarkus:dev`.

For example, to run the Avro variant:

1. in the first terminal, run `mvn quarkus:dev` from the `avro-serde/avro-serde-publisher`.
2. in the second terminal, run `mvn quarkus:dev` from the `avro-serde/avro-serde-consumer`.