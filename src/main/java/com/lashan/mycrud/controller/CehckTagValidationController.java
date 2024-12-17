package com.lashan.mycrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tagvalidation")
public class CehckTagValidationController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping
    public void save(){

    }
}
