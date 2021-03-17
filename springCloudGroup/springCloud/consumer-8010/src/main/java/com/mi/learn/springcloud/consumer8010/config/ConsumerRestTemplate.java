package com.mi.learn.springcloud.consumer8010.config;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerRestTemplate {

    @Bean
    public RestTemplate getResultConfig(){
        return new RestTemplate();
    }

}
