package edu.umn.kafka.controller;

import edu.umn.kafka.service.ProducerService;
import edu.umn.kafka.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {
    private ProducerService service;


    @Autowired
    public ProducerController(ProducerService service) {
        this.service = service;
    }

    private static int count = 1;

    @PostMapping(value = "/api/producer/v1.0", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> kafkaProducer() {
        String value = "Hello World"+count;
        Message msg = new Message(count, value);
        service.send(msg);
        count++;
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

}