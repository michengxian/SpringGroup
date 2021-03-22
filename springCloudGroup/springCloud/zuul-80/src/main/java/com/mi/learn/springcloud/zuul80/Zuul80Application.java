package com.mi.learn.springcloud.zuul80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul80Application {

    public static void main(String[] args) {
        SpringApplication.run(Zuul80Application.class, args);
    }

}
