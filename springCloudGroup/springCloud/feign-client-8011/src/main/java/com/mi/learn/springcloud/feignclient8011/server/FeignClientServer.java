package com.mi.learn.springcloud.feignclient8011.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("feign-server-name")
public interface FeignClientServer {

    @RequestMapping("/queryUserById")
    String queryUserById(@RequestParam("id") int id);

}
