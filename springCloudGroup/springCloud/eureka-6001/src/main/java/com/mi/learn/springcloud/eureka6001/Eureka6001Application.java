package com.mi.learn.springcloud.eureka6001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka6001Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka6001Application.class, args);
    }

}
