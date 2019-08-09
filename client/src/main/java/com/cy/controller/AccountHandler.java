package com.cy.controller;

import com.cy.entity.Account;
import com.cy.entity.Admin;
import com.cy.entity.User;
import com.cy.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.LinkedList;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session) {
        Object object = accountFeign.login(username, password, type);
        LinkedHashMap<String, Object> hashMap = (LinkedHashMap) object;
        String result = null;
        String idStr = null;
        if (object == null) {
            result = "login";
        } else {
            switch (type) {
                case "user":
                    User user = new User();
                    idStr = hashMap.get("id") + "";

                    user.setId(Long.parseLong(idStr));
                    user.setNickname((String) hashMap.get("nickname"));
                    session.setAttribute("user", user);

                    result = "redirect:/account/redirect/index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    idStr = hashMap.get("id") + "";

                    admin.setId(Long.parseLong(idStr));
                    admin.setUsername((String) hashMap.get("username"));
                    session.setAttribute("admin", admin);

                    result = "redirect:/account/redirect/main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping("/redirect/{target}")
    public String redirect(@PathVariable("target") String target) {
        return target;
    }

//    private User convertUser(Account account){
//        User user = new User();
//        user.setUsername(ReflectUtils.getFieldValue(account,"username")+"");
//        user.setPassword(ReflectUtils.getFieldValue(account,"password")+"");
//        user.setGender(ReflectUtils.getFieldValue(account,"gender")+"");
//        user.setId((long)(ReflectUtils.getFieldValue(account,"id")));
//        user.setNickname(ReflectUtils.getFieldValue(account,"nickname")+"");
//        user.setRegisterdate((Date)(ReflectUtils.getFieldValue(account,"registerdate")));
//        user.setTelephone(ReflectUtils.getFieldValue(account,"telephone")+"");
//        return user;
//    }
//
//    private Admin convertAdmin(Account account){
//        Admin admin = new Admin();
//        admin.setUsername(ReflectUtils.getFieldValue(account,"username")+"");
//        admin.setPassword(ReflectUtils.getFieldValue(account,"password")+"");
//        admin.setId((long)(ReflectUtils.getFieldValue(account,"id")));
//        return admin;
//    }
}

