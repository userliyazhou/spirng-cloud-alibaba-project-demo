package org.demo.hello.dddd.uyyyy.iiii;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController1 {
    @GetMapping("/test1")
    public String  test1(){

        return  "test1";
    }
}
