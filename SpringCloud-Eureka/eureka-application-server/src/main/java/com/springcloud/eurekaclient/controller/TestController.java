package com.springcloud.eurekaclient.controller;

import com.springcloud.eurekaclient.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Value("${application.userbean.id}")
    private int userBeanId;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/getUserList")
    public List<UserBean> getUserList(){
        List<UserBean> result = new ArrayList<>();
        UserBean bean = new UserBean("mi",18,userBeanId);
        result.add(bean);
        System.out.println("EurekaApplicationServerApplication A getUserList");
        return result;
    }


    @RequestMapping(value="/getTest")
    public String getTest(){
        return "EurekaApplicationServerApplication A getUserList";
    }



    @RequestMapping("/getUser")
    public String getUser(@RequestParam("id") Long id) {
        System.out.println("application-service-a");
        //获取用户微服务实例
        ServiceInstance serviceInstance = discoveryClient.getInstances("application-service-a").get(0);
        //控制台输出微服务被调用时间、端口号等信息
        System.out.println("time: " + new Timestamp(System.currentTimeMillis()) + ", serverId: " + serviceInstance.getServiceId() + ", host:" +
                " " + serviceInstance.getHost()
                + ", port: " + serviceInstance.getPort());
        return "user_id_" + id;
    }

}
