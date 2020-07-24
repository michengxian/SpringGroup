package com.springcloud.eurekaapplicationclient.controller;

import com.springcloud.eurekaapplicationclient.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value="/getUserList")
    public List<UserBean> getUserList(){
        ServiceInstance si = this.loadBalancerClient.choose("eureka-application-service");
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(si.getHost())
                .append(":").append(si.getPort()).append("/getUserList");

        RestTemplate rt = new RestTemplate();
        ParameterizedTypeReference<List<UserBean>> type =
                new ParameterizedTypeReference<List<UserBean>>() {
                };
        ResponseEntity<List<UserBean>> response =
                rt.exchange(sb.toString(), HttpMethod.GET, null, type);
        List<UserBean> result = response.getBody();

        System.out.println("调用"+sb.toString());
        System.out.println("result"+result);
        return result;
    }

    @RequestMapping(value="/getTest")
    public String getTest() {
        ResponseEntity<String> list = restTemplate.getForEntity("http://eureka-application-service/getTest",String.class);
        System.out.println("getTest"+list.getBody());
//        List<UserBean> userBeanList = new ArrayList<>();
        return list.getBody();
    }
}
