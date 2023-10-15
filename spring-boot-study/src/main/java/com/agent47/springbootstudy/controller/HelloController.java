package com.agent47.springbootstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/",method= RequestMethod.GET)
    public String hello(){
        return "Hello Controller hope it works";
    }
}
