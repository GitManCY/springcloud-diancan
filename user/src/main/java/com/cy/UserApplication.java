package com.cy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author a123
 * @title: UserApplication
 * @projectName springcloud-diancan
 * @description: TODO
 * @date 2019/8/83:45 PM
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.cy.repository")
public class UserApplication {

    public static void main(String args[]) {
        SpringApplication.run(UserApplication.class,args);
    }
}
