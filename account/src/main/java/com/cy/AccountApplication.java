package com.cy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author a123
 * @title: AccountApplication
 * @projectName springcloud-diancan
 * @description: TODO
 * @date 2019/8/86:54 PM
 */
@SpringBootApplication
@MapperScan("com.cy.repository")
public class AccountApplication {

    public static void main(String args[]) {
        SpringApplication.run(AccountApplication.class,args);
    }
}
