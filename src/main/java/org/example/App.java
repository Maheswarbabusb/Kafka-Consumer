package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers","localhost:9092");
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        properties.put("value.serializer",
                "org.example.StringSerializer");

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
           // Truck truck = new Truck(1, "23.1", "22.7");
            ProducerRecord<String, String> record = new ProducerRecord<>("truck-topic", "TestTruck", "23.2L-20.1L");
            RecordMetadata send = producer.send(record).get();
            System.out.println( "Message Sent" );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
