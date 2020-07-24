package com.springcloud.eurakeserver01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurakeServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(EurakeServer01Application.class, args);
    }

}
