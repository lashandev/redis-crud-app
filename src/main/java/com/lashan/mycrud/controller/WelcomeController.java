package com.lashan.mycrud.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
@Log4j2
public class WelcomeController {

//    @RequestMapping(value = "/call",method = RequestMethod.GET)
    @GetMapping("/call")
    public String welcome(){
        log.info("Welcome to My First Spring boot Application");
        return "Welcome to My App";
    }
}
