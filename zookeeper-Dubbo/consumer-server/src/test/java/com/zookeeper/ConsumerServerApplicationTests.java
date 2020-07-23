package com.zookeeper;

import com.zookeeper.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServerApplicationTests {

    @Autowired
    private UserServiceImpl service;

    @Test
    void contextLoads() {

        service.byTicket();

    }

}
