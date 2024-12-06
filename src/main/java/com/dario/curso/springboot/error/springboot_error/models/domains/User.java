package com.dario.curso.springboot.error.springboot_error.models.domains;

public class User {
    private String name;
    private String lastname;
    private Long id;

    private Role role;

    public User() {}
    
    public User(String name, String lastname, Long id) {
        this.name = name;
        this.id = id;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public String getRoleName() {
        return role.getName();
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
}