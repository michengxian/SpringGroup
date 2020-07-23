package com.zookeeper.controller;

import com.zookeeper.service.TicketService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {


    @DubboReference
    private TicketService ticketService;

    @GetMapping("/getTicket")
    public String getTicket(){
        return ticketService.getTicket();
    }

}
