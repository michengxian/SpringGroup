package com.springcloud.springopenfeign.controller;

import com.springcloud.springopenfeign.server.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    FeignService service;

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public String getUser(@RequestParam("id") Long id) {
        service.getUser(id);
        return "FeignController user_id_" + id;
    }

    @RequestMapping("/getTest")
    public String getTest() {
        String res = service.getTest();
        return "FeignController "+ res ;
    }


    @RequestMapping("/demo2/zuul")
    public String zuul() {
        return "FeignController zuul success";
    }

}
