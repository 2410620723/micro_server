package com.micro.server.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zxm
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.micro.server.item.controller", "com.micro.server.item.service"})
public class ItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class, args);
    }
}
