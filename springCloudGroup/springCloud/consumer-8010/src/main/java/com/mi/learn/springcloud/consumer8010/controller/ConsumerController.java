package com.mi.learn.springcloud.consumer8010.controller;

import com.alibaba.fastjson.JSONObject;
import com.mi.learn.springcloud.base.bean.RequestBean;
import com.mi.learn.springcloud.base.bean.ResponseBean;
import com.mi.learn.springcloud.bean.UserInfoBean;
import com.mi.learn.springcloud.consumer8010.server.ConsumerServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    ConsumerServer consumerServer;

    @RequestMapping(value = "/queryUserById",method = RequestMethod.GET)
    public ResponseBean<UserInfoBean> queryUserById(RequestBean<String> requestBean, ResponseBean<UserInfoBean> responseBean){
        log.info("ConsumerController queryUserById req : {}",JSONObject.toJSON(requestBean));
        UserInfoBean userInfoBean = consumerServer.queryUserById1(requestBean);
        log.info("ConsumerController queryUserById res : {}", JSONObject.toJSON(userInfoBean));
        responseBean.setResponse(userInfoBean);
        return responseBean;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseBean<Boolean> addUser(@RequestBody RequestBean<UserInfoBean> requestBean, ResponseBean<Boolean> responseBean){
        log.info("ConsumerController addUser req : {}",JSONObject.toJSON(requestBean));
        Boolean flag = consumerServer.addUser1(requestBean);
        log.info("ConsumerController addUser res : {}", JSONObject.toJSON(flag));
        responseBean.setResponse(flag);
        return responseBean;
    }


    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public ResponseBean<String> info(ResponseBean<String> responseBean){
        log.info("ConsumerController info");
        responseBean.setResponse("ConsumerController info");
        return responseBean;
    }

}
