package edu.umn.kafka.controller;

import edu.umn.kafka.service.ProducerService;
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

    @GetMapping(value = "/api/producer/v1.0", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> kafkaProducer() {
        //service.send(count,"Hello World"+count);
        count++;
        return new ResponseEntity<>("Message" + count + "Posted", HttpStatus.OK);
    }

}
