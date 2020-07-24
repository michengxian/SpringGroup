package com.springcloud.springopenfeign.server;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "application-service")
public interface FeignService {

    @RequestMapping("/getUser")
    String getUser(@RequestParam("id") Long id);

    @RequestMapping("/getTest")
    String getTest();

}
