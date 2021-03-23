package com.mi.learn.springcloud.consumer8010;

import com.mi.learn.springcloud.consumer8010.server.ConsumerServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Consumer8010ApplicationTests {

    @Autowired
    private ConsumerServer server;


    @Test
    void contextLoads() {

        for (int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    server.info();
                }
            }).start();

        }

    }

}
