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

<<<<<<< Updated upstream
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("partitioner.class",VIPPartitioner.class.getName());

        try (KafkaProducer<String, String> producer = new KafkaProducer<>(properties)) {
          //  Truck truck = new Truck(1, "23.1", "22.7");
            ProducerRecord<String, String> record = new ProducerRecord<>("Truck-Partitioned-Topic","Truck-test", "37.2431-15.793");
            RecordMetadata send = producer.send(record).get();
            System.out.println( "Message Sent" );
        } catch (Exception e) {
            e.printStackTrace();
=======
        properties.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "truck-partitioned-group");

        KafkaConsumer<String, String> consumer=new KafkaConsumer<>(properties);

        consumer.subscribe(Collections.singletonList("Truck-Partitioned-Topic"));

        ConsumerRecords<String, String> poll = consumer.poll(Duration.ofSeconds(20));

        for(ConsumerRecord<String, String> kaf:poll){

            System.out.println(kaf.key());
            System.out.println(kaf.value());
            System.out.println(kaf.partition());
//                    getId());
//            System.out.println(kaf.value().getLongitude());
//            System.out.println(kaf.value().getLatitude());
>>>>>>> Stashed changes
        }

    }
}
