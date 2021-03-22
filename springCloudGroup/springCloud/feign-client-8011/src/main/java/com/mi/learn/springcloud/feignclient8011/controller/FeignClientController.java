package com.mi.learn.springcloud.feignclient8011.controller;

import com.alibaba.fastjson.JSONObject;
import com.mi.learn.springcloud.base.bean.RequestBean;
import com.mi.learn.springcloud.base.bean.ResponseBean;
import com.mi.learn.springcloud.bean.UserInfoBean;
import com.mi.learn.springcloud.feignclient8011.server.FeignClientServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignClientController {

    @Autowired
    FeignClientServer clientServer;

    @RequestMapping(value = "/queryUserById",method = RequestMethod.GET)
    public ResponseBean<String> queryUserById(RequestBean<String> requestBean, ResponseBean<String> responseBean){
        log.info("FeignClientController queryUserById req : {}", JSONObject.toJSON(requestBean));
        String userInfoBean = clientServer.queryUserById(Integer.valueOf(requestBean.getRequest()));
        log.info("FeignClientController queryUserById res : {}", JSONObject.toJSON(userInfoBean));
        responseBean.setResponse(userInfoBean);
        return responseBean;
    }


}
