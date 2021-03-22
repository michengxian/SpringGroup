package com.mi.learn.springcloud.feignserver8003.server;


import com.alibaba.fastjson.JSON;
import com.mi.learn.springcloud.base.bean.RequestBean;
import com.mi.learn.springcloud.base.bean.ResponseBean;
import com.mi.learn.springcloud.bean.UserInfoBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class FeignServerServer {


    @Autowired
    private RestTemplate restTemplate;

    
    private static final String PROVIDER_URL = "http://localhost:8001/";


    public UserInfoBean queryUserById(RequestBean<String> requestBean){
        String url = PROVIDER_URL+"queryUserById"+"?seqNo=1614914237651&sourceSystem=hyt&version=2&request=2";
        Map<String,Object> map = new HashMap<>();
        map.put("seqNo","1614914237651");
        map.put("sourceSystem","hyt");
        map.put("version",1);
        map.put("request",2);
        ResponseEntity<ResponseBean> responseEntity = restTemplate.getForEntity(url,ResponseBean.class,map);
        log.info("ConsumerServerImpl queryUserById res {}",responseEntity);
        ResponseBean obj = responseEntity.getBody();
        JSON json = JSON.parseObject(JSON.toJSONString(obj.getResponse()));
        UserInfoBean res = JSON.toJavaObject(json,UserInfoBean.class);
        return res;
    }



}
