package com.springcloud.ribbon.controller;

import com.springcloud.ribbon.server.RibbonServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {

    @Autowired
    RibbonServer server;


    @RequestMapping("/ribbon")
    public String ribbon(){
        return server.helloService();
    }

}
