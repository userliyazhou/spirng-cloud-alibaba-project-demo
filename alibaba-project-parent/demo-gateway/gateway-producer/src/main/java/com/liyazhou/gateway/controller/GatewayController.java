package com.liyazhou.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
@GetMapping("/producer/hello")
    public  String hello(){
    return  "hello gateway pruducer";
}
}
