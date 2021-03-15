package com.mi.learn.springcloud.eureka6002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka6002Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka6002Application.class, args);
    }

}
