package com.springcloud.eurekaapplicationserver01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaApplicationServer01Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationServer01Application.class, args);
    }

}
