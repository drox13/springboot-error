package com.dario.curso.springboot.error.springboot_error.services;

import java.util.List;

import com.dario.curso.springboot.error.springboot_error.models.domains.User;

public interface UserService {
    List<User> findAll();
    User findByID(Long id);
}
