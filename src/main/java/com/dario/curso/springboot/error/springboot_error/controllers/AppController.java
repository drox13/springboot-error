package com.dario.curso.springboot.error.springboot_error.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppController {
    
    @GetMapping("/app")
    public String index(){
        //int value = 100/0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return" Ok 200";
    }
}
