package com.cy.repository;


import com.cy.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}
