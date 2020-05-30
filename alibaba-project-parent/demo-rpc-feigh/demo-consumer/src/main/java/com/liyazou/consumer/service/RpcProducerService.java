package com.liyazou.consumer.service;

import com.liyazou.consumer.service.impl.RpcProducerServiceImp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demo-producer",fallback = RpcProducerServiceImp.class )

public interface RpcProducerService {
    @GetMapping("/teseProducer")
    public  String  testProducer(@RequestParam  String  msg);
}
