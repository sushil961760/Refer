package com.ezetap.refer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/home")
    public String home() {
        return "Hello World";
    }
}
