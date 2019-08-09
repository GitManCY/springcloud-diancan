package com.cy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author a123
 * @title: OrderApplication
 * @projectName springcloud-diancan
 * @description: TODO
 * @date 2019/8/78:43 PM
 */
@SpringBootApplication
@MapperScan("com.cy.repository")
public class MenuApplication {
    public static void main(String args[]) {
        SpringApplication.run(MenuApplication.class,args);
    }
}
