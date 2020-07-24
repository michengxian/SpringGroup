package com.springcloud.eurekaclient.controller;

import com.springcloud.eurekaclient.bean.UserBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Value("${application.userbean.id}")
    private int userBeanId;

    @RequestMapping(value="/getUserList")
    public List<UserBean> getUserList(){
        List<UserBean> result = new ArrayList<>();
        UserBean bean = new UserBean("mi",18,userBeanId);
        result.add(bean);
        System.out.println("EurekaApplicationServerApplication getUserList");
        return result;
    }


    @RequestMapping(value="/getTest")
    public String getTest(){
        return "EurekaApplicationServerApplication getUserList";
    }

}
