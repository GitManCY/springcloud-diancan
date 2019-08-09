package com.cy.controller;

import com.cy.entity.User;
import com.cy.entity.UserVO;
import com.cy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.Date;

/**
 * @author a123
 * @title: UserHandler
 * @projectName springcloud-diancan
 * @description: TODO
 * @date 2019/8/83:45 PM
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        return "user的端口是:" + port;
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{page}/{limit}")
    public UserVO findAll(@PathVariable("page") int index, @PathVariable("limit") int limit){
        return new UserVO(0, "", userRepository.count(), userRepository.findAll(index, limit));
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        user.setRegisterdate(new Date());
        userRepository.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }

    @GetMapping("/count")
    public int count(){
        return userRepository.count();
    };


}
