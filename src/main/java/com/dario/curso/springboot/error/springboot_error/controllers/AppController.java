package com.dario.curso.springboot.error.springboot_error.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.dario.curso.springboot.error.springboot_error.models.domains.User;
import com.dario.curso.springboot.error.springboot_error.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping()
    public String index(){
        //int value = 100/0;
        int value = Integer.parseInt("20x");
        System.out.println(value);
        return" Ok 200";
    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name ="id") Long id) {
        User user = service.findByID(id);
        System.out.println(user.getLastname());
        return user;
    }   
}