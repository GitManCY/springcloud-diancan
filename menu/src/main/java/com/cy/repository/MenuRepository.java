package com.cy.repository;

import com.cy.entity.Menu;

import java.util.List;

public interface MenuRepository {
    public List<Menu> findAll(int index, int limit);

    public int count();

    public void save(Menu menu);

    public Menu findById(long id);

    public void update(Menu menu);

    public void deleteById(long id);
}
