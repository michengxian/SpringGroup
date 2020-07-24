package com.springcloud.eurekaapplicationclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class EurekaApplicationClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationClientApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

}
