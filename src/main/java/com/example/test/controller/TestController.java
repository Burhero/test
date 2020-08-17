package com.example.test.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author lhb
 * @Date 2020/8/11 10:35
 */
@RestController
public class TestController {
    @GetMapping("test1/{test}")
    public String test1(@PathVariable String test){
        return test;
    }
    @GetMapping("test/{test}")
    public String test(@PathVariable String test){
        return test;
    }
}
