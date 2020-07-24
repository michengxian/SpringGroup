package com.springcloud.eurekaapplicationclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest
class EurekaApplicationClientApplicationTests {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    void contextLoads() {
        ServiceInstance si = this.loadBalancerClient.choose("application-service-b");
        if (si == null){
            si = this.loadBalancerClient.choose("application-service-a");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(si.getHost())
                .append(":").append(si.getPort()).append("/getUserList");
        System.out.println("本次访问的service是： " + sb.toString());
        RestTemplate rt = new RestTemplate();
        ParameterizedTypeReference<List<Map<String, Object>>> type =
                new ParameterizedTypeReference<List<Map<String, Object>>>() {
                };
        /*
         * ResponseEntity:封装了返回值信息，相当于是HTTP Response中的响应体。
         * 发起REST请求。
         */
        ResponseEntity<List<Map<String, Object>>> response =
                rt.exchange(sb.toString(), HttpMethod.GET, null, type);
        /*
         * ResponseEntity.getBody() - 就是获取响应体中的java对象或返回数据结果。
         */
        List<Map<String, Object>> result = response.getBody();
        System.out.println(result);
    }

}
