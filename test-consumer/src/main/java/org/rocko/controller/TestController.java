package org.rocko.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.rockobass.commonapi.ITest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Reference
    private ITest iTest;

    @Value("${server.port}")
    private String port;


    @GetMapping("/1")
    public String test1() {
        return "conport:"+port+iTest.test1();
    }

    @GetMapping("/2")
    public String test2() {
        return "conport:"+port+iTest.test2();
    }
}
