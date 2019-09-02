package com.micro.server.eureka.slave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka注册中心
 *
 * @author zxm
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaSlaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaSlaveApplication.class, args);
    }
}
