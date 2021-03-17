package com.mi.learn.springcloud.consumer8010.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mi.learn.springcloud.base.bean.RequestBean;
import com.mi.learn.springcloud.base.bean.ResponseBean;
import com.mi.learn.springcloud.base.except.DefaultException;
import com.mi.learn.springcloud.bean.UserInfoBean;
import com.mi.learn.springcloud.consumer8010.config.ConsumerRestTemplate;
import com.mi.learn.springcloud.consumer8010.tool.HttpUtils;
import com.netflix.ribbon.proxy.annotation.Http;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class ConsumerServerImpl implements ConsumerServer {

    @Autowired
    private RestTemplate restTemplate;
//    private HttpUtils utils;

    private static final String PROVIDER_URL = "http://localhost:8001/provider/";
//    http://localhost:8010/consumer/queryUserById?seqNo=1614914237651&sourceSystem=hyt&version=2&request=2


    /**
     * map
     * @param requestBean
     * @return
     */
    public UserInfoBean queryUserById(RequestBean<String> requestBean){
        String url = PROVIDER_URL+"queryUserById"+"?seqNo=1614914237651&sourceSystem=hyt&version=2&request=2";
        ResponseBean<Object> responseBean = (ResponseBean) restTemplate.getForObject(url,ResponseBean.class);
        log.info("ConsumerServerImpl queryUserById res {}",responseBean);
        Object obj = responseBean.getResponse();
        JSON json = JSON.parseObject(JSON.toJSONString(obj));
        UserInfoBean res = JSON.toJavaObject(json,UserInfoBean.class);
//        ResponseEntity<UserInfoBean> res = utils.get(PROVIDER_URL+"queryUserById"+"?seqNo=1614914237651&sourceSystem=hyt&version=2&request=2",UserInfoBean.class);
        return res;
    }


    /**
     * 对象
     * @param requestBean
     * @return
     */
    public UserInfoBean queryUserById1(RequestBean<String> requestBean){
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
//        ResponseEntity<UserInfoBean> res = utils.get(PROVIDER_URL+"queryUserById"+"?seqNo=1614914237651&sourceSystem=hyt&version=2&request=2",UserInfoBean.class);
        return res;
    }


    /**
     * map
     * @param requestBean
     * @return
     */
    public Boolean addUser(RequestBean<UserInfoBean> requestBean){
        String url = PROVIDER_URL+"addUser";
        Map<String,Object> map = new HashMap<>();
        map.put("name",requestBean.getRequest().getName());
        map.put("roleName",requestBean.getRequest().getRoleName());
        ResponseBean<Object> responseBean = (ResponseBean) restTemplate.postForObject(url,requestBean,ResponseBean.class);
        log.info("ConsumerServerImpl addUser res {}",responseBean);
        Object obj = responseBean.getResponse();
        log.info("ConsumerServerImpl addUser obj {}",obj);
        if (obj==null||StringUtils.isBlank(JSON.toJSONString(obj))){
            throw new DefaultException(responseBean.getDesc());
        }
        JSON json = JSON.parseObject(JSON.toJSONString(obj));
        Boolean res = JSON.toJavaObject(json,Boolean.class);
        return res;
    }


    /**
     * 通过对象方式传
     * @param requestBean
     * @return
     */
    public Boolean addUser1(RequestBean<UserInfoBean> requestBean){
        String url = PROVIDER_URL+"addUser";
        ResponseEntity<ResponseBean> responseEntity = restTemplate.postForEntity(url,requestBean,ResponseBean.class,new HashMap<>());
        log.info("ConsumerServerImpl addUser res {}",responseEntity);
        ResponseBean responseBean = responseEntity.getBody();
        log.info("ConsumerServerImpl addUser obj {}",responseBean);
        if (responseBean.getResponse()==null||StringUtils.isBlank(JSON.toJSONString(responseBean.getResponse()))){
            throw new DefaultException(responseBean.getDesc());
        }
        JSON json = JSON.parseObject(JSON.toJSONString(responseBean.getResponse()));
        Boolean res = JSON.toJavaObject(json,Boolean.class);
        return res;
    }
}
