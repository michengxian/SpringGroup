package com.springcloud.eurekaapplicationserver01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Value("${application.userbean.id}")
    private int userBeanId;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/getTest")
    public String getTest(){
        return "EurekaApplicationServerApplication getUserList";
    }



    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable("id") Long id) {

        //获取用户微服务实例
        ServiceInstance serviceInstance = discoveryClient.getInstances("USER").get(0);
        //控制台输出微服务被调用时间、端口号等信息
        System.out.println("time: " + new Timestamp(System.currentTimeMillis()) + ", serverId: " + serviceInstance.getServiceId() + ", host:" +
                " " + serviceInstance.getHost()
                + ", port: " + serviceInstance.getPort());
        return "user_id_" + id;
    }

}
