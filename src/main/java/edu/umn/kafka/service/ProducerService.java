package edu.umn.kafka.service;

import edu.umn.kafka.vo.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topic.name.first-topic}")
    private String topicNameFirst;

    @Value("${topic.name.second-topic}")
    private String topicNameSecond;

    ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Message msg){
        if(msg.getId() % 2 == 0){
            kafkaTemplate.send(topicNameSecond, msg.getMessage());
            System.out.println("Producer -- sent to second topic -- " + msg.getMessage());
        }else {
            kafkaTemplate.send(topicNameFirst, msg.getMessage());
            System.out.println("Producer -- sent to first topic -- " + msg.getMessage());
        }
    }

}
