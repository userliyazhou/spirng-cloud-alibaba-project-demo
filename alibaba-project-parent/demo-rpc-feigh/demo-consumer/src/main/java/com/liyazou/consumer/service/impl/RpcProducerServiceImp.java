package com.liyazou.consumer.service.impl;

import com.liyazou.consumer.service.RpcProducerService;
import org.springframework.stereotype.Component;

@Component
public class RpcProducerServiceImp implements RpcProducerService {
    @Override
    public String testProducer(String msg) {
        return "不好意思，调用失败";
    }
}
