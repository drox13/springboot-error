package com.dario.curso.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dario.curso.springboot.error.springboot_error.models.domains.User;

@Service
public class UserServiceImp implements UserService{

    private List<User> users;

    public UserServiceImp(){
        this.users = new ArrayList<>();
        users.add(new User("Pepe", "Gonzalez", 1l ));
        users.add(new User("Maria", "Beceerra", 2l ));
        users.add(new User("Mojica", "Perez", 3l ));
        users.add(new User("Josefa", "ramires", 4l ));
        users.add(new User("Alex", "Puertas", 5l ));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findByID(Long id) {
        User user = null;
        for (User u : users) {
            if(u.getId().equals(id)){
                user = u;
                break;
            }
        }
        return user;
    }

    

}
