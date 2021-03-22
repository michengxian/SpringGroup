package com.mi.learn.springcloud.feignserver8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class FeignServer8002Application {

    public static void main(String[] args) {
        SpringApplication.run(FeignServer8002Application.class, args);
    }

    @Bean
    public RestTemplate getResultConfig(){
        return new RestTemplate();
    }

}
