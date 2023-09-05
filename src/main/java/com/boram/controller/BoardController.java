package com.boram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


}
