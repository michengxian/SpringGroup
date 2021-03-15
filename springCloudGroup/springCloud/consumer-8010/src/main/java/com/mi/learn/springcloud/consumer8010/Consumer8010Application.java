package com.mi.learn.springcloud.consumer8010;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Consumer8010Application {

    public static void main(String[] args) {
        SpringApplication.run(Consumer8010Application.class, args);
    }

}
