package com.zookeeper.service;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "mi zookeeper server success";
    }

}
