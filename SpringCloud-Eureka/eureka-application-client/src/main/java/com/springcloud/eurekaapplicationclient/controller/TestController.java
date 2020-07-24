package com.springcloud.eurekaapplicationclient.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.springcloud.eurekaapplicationclient.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value="/getUserList")
    public List<UserBean> getUserList(){
        ServiceInstance si = this.loadBalancerClient.choose("application-service-a");
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
        ResponseEntity<String> list = restTemplate.getForEntity("http://application-service-a/getTest",String.class);
        System.out.println("getTest"+list.getBody());
//        List<UserBean> userBeanList = new ArrayList<>();
        return list.getBody();
    }


    @RequestMapping("/ribbon")
    public String testRibbon() {
        String userId = "";
        //调用10次用户微服务
        for (int i = 1; i <= 10; i++) {
            //微服务之间调用时，需将serviceId(spring.application.name)作为请求路径父级目录
            String url = "http://application-service-a/getUser?id="+i;
            System.out.println(url);
            userId = restTemplate.getForObject(url, String.class);
        }
        return userId;
    }


    @RequestMapping(value="/getTest01")
    public String getTest01() {
        ResponseEntity<String> list = restTemplate.getForEntity("http://application-service-b/getTest",String.class);
        System.out.println("getTest"+list.getBody());
//        List<UserBean> userBeanList = new ArrayList<>();
        return list.getBody();
    }



    @RequestMapping("/ribbon01")
    public String testRibbon01() {
        String userId = "";
        //调用10次用户微服务
        for (int i = 1; i <= 10; i++) {
            //微服务之间调用时，需将serviceId(spring.application.name)作为请求路径父级目录
            String url = "http://application-service-b/getUser?id="+i;
            System.out.println(url);
            userId = restTemplate.getForObject(url, String.class);
        }
        return userId;
    }

}
