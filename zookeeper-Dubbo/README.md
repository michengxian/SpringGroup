# zookeeper+dubbo 搭建RPC服务

## 注意事项

**首先需要安装****zookeeper，并运行**



> 第一次启动会失败：

**把conf目录下的zoo_sample.cfg 改成zoo.cfg 即可**



zookeeper 常用命令

```
# 进入目录
cd apache-zookeeper-3.5.8-bin/bin

# 开启zookeeper
./zkServer.sh start

# 停止zookeeper
./zkServer.sh stop


# Cli连接zookeeper
./zkCli.sh -server 127.0.0.1:2181

# 查看zookeeper中注册了哪些服务
ls /

# 查看zookeeper中某个服务
get /zk_test

# 设置zookeeper中的服务
set /zk_test junk

# 删除
delete /zk_test
```

**
**

## consumer-server（消费者）

1. 修改pom.xml，引入依赖
2. 修改application.properties
3. 编写可以引入的server类



### pom.xml

```
<!--导入依赖 Dubbo + zookeeper  -->

<!-- Dubbo -->
<dependency>
    <groupId>org.apache.dubbo</groupId>
    <artifactId>dubbo-spring-boot-starter</artifactId>
    <version>2.7.7</version>
</dependency>

<!--zkclient-->
<!-- https://mvnrepository.com/artifact/com.github.sgroschupf/zkclient -->
<dependency>
    <groupId>com.github.sgroschupf</groupId>
    <artifactId>zkclient</artifactId>
    <version>0.1</version>
</dependency>

<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-framework</artifactId>
    <version>4.1.0</version>
</dependency>
<dependency>
    <groupId>org.apache.curator</groupId>
    <artifactId>curator-recipes</artifactId>
    <version>4.1.0</version>
</dependency>
<dependency>
    <groupId>org.apache.zookeeper</groupId>
    <artifactId>zookeeper</artifactId>
    <version>3.4.8</version>
    <exclusions>
        <exclusion>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```



### application.properties

```
server.port=8001

# 服务器应用名字
dubbo.application.name=provider-server

# 注册中心地址
dubbo.registry.address=zookeeper://127.0.0.1:2181

# 哪些服务要被注册
dubbo.scan.base-packages=com.zookeeper.service
```



### TicketServiceImpl

```
package com.zookeeper.service;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class TicketServiceImpl implements TicketService {

    @Override
    public String getTicket() {
        return "mi zookeeper server success";
    }
}
```



## provider-server（服务者）

1. 首先修改pom.xml
2. 引入provider-server（服务者）的server类
3. 使用provider-server（服务者）的server类



### pom.xml 同上

### UserServiceImpl使用

```
package com.zookeeper.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    //去注册中心拿到服务
    @DubboReference()
    private TicketService ticketService;

    public void byTicket(){
        String ticket = ticketService.getTicket();
        System.out.println(ticket);
    }
}
```

### ConsumerController 使用

```
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
```