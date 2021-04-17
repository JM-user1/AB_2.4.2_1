package com.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartedController {

    @GetMapping("/")
    public String startPage(){
        return "started-page";
    }

    @GetMapping("/info")
    public String userNews(){
        return "info";
    }
}
