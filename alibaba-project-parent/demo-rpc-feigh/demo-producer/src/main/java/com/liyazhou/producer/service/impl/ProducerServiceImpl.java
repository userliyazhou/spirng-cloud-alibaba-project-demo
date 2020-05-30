package com.liyazhou.producer.service.impl;

import com.liyazhou.producer.service.ProducerService;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {
    @Override
    public String testProducer(String  msg) {
        return "调用producer成功!! "+msg;
    }
}
