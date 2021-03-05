package com.ezetap.refer.controller;

import org.json.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class controller {

    @GetMapping("/home")
    public String home() {
        return "Hello World";
    }





}
