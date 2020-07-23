package com.zookeeper.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

//加入spring中
//@DubboService
@Service
public class UserServiceImpl implements UserService {

    //调用provider-server服务

    //去注册中心拿到服务
    //@Reference  引用  可以定义路径相同的接口名
    @DubboReference()
    private TicketService ticketService;

    public void byTicket(){
        String ticket = ticketService.getTicket();
        System.out.println(ticket);
    }

}
