package com.micro.server.item.slave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zxm
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.micro.server.item.slave.controller", "com.micro.server.item.slave.service"})
@EnableEurekaClient
public class ItemSlaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemSlaveApplication.class, args);
    }
}
