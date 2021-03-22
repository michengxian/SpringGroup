package com.mi.learn.springcloud.feignclient8012;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignClient8012Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignClient8012Application.class, args);
    }

}
