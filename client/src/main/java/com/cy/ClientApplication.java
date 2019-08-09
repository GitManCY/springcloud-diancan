package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author a123
 * @title: ClientApplication
 * @projectName springcloud-diancan
 * @description: TODO
 * @date 2019/8/89:08 AM
 */
@SpringBootApplication
@EnableFeignClients
@ServletComponentScan
public class ClientApplication {

    public static void main(String args[]) {
        SpringApplication.run(ClientApplication.class,args);
    }

}
