package com.liyazou.consumer.controller;


import com.liyazou.consumer.service.RpcProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConsumerController {
    @Autowired
    RpcProducerService rpcProducerService;

    @GetMapping("/tesetRpc")
    public  String  tesetRpc(String  msg){
        String testProducer = rpcProducerService.testProducer("我是消费者，我来调用rpc");
        return testProducer;
    }
}
