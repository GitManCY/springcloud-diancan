package com.cy.controller;

import com.cy.entity.Menu;
import com.cy.entity.MenuVO;
import com.cy.entity.Type;
import com.cy.repository.MenuRepository;
import com.cy.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author a123
 * @title: OrderController
 * @projectName springcloud-diancan
 * @description: TODO
 * @date 2019/8/78:42 PM
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private TypeRepository typeRepository;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/index")
    public String index() {
        return "menu的端口是：" + port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
        return new MenuVO(0, "", menuRepository.count(), menuRepository.findAll(index, limit));
    }

    @GetMapping("/findTypes")
    public List<Type> findTypes() {
        return typeRepository.findAll();
    }


    /*
        CRUD
     */

    @PostMapping("/save")
    public void save(@RequestBody Menu menu) {
        menuRepository.save(menu);
    }

    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id) {
        return menuRepository.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu) {
        menuRepository.update(menu);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id) {
        menuRepository.deleteById(id);
    }


}
