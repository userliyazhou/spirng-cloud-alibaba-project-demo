package com.liyazhou.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulController {
@GetMapping("/producer/hello")
    public  String hello(){
    return  "hello zuul pruducer";
}
}
