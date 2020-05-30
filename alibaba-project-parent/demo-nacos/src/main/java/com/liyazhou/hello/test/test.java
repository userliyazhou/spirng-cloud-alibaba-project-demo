package com.liyazhou.hello.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class test {
    @GetMapping("/hello")

    @ResponseBody
    public Map<String ,Object> gethello(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("helo","中平你哥哥IP人");
        return hashMap;
    }
}
