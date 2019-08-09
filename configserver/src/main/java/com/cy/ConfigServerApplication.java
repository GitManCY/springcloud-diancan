package com.cy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author a123
 * @title: ConfigServerApplication
 * @projectName springcloud-diancan
 * @description: TODO
 * @date 2019/8/71:32 PM
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String args[]) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }

}
