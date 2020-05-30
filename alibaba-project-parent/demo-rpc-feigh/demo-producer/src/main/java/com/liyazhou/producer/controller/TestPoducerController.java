package com.liyazhou.producer.controller;

import com.liyazhou.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestPoducerController {
    @Autowired
    ProducerService producerService;
    @GetMapping("/teseProducer")
    public  String  testProducer(String  msg){
        String producer = producerService.testProducer(msg);
        return producer;
    }
}
