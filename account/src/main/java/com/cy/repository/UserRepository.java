package com.cy.repository;


import com.cy.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
