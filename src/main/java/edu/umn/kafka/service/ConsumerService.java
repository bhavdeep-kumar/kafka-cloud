package edu.umn.kafka.service;

import org.springframework.stereotype.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;

import java.util.List;


@Service
public class ConsumerService {

    @KafkaListener(topics = "${topic.name.first-topic}")
    public void receive(String message,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        System.out.println("Consumer -- received from first topic -- " + message);

    }
}
