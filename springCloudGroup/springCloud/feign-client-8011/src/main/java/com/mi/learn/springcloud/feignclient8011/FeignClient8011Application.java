package com.mi.learn.springcloud.feignclient8011;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignClient8011Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignClient8011Application.class, args);
    }

}
