package com.mi.learn.springcloud.feignserver8003.controller;

import com.alibaba.fastjson.JSONObject;
import com.mi.learn.springcloud.base.bean.RequestBean;
import com.mi.learn.springcloud.base.bean.ResponseBean;
import com.mi.learn.springcloud.bean.UserInfoBean;
import com.mi.learn.springcloud.feignserver8003.server.FeignServerServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignServerController {

    @Autowired
    FeignServerServer feignServerServer;

    @RequestMapping(value = "/queryUserById",method = RequestMethod.GET)
    public ResponseBean<UserInfoBean> queryUserById(RequestBean<String> requestBean, ResponseBean<UserInfoBean> responseBean){
        log.info("ConsumerController queryUserById req : {}", JSONObject.toJSON(requestBean));
        UserInfoBean userInfoBean = feignServerServer.queryUserById(requestBean);
        log.info("ConsumerController queryUserById res : {}", JSONObject.toJSON(userInfoBean));
        responseBean.setResponse(userInfoBean);
        return responseBean;
    }



}
