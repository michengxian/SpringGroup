package com.mi.learn.springcloud.zuul80.server;


import com.alibaba.fastjson.JSON;
import com.mi.learn.springcloud.base.bean.ResponseBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA
 * Description: 网关的降级操作
 *
 * @author:3742
 * @date:2018/4/14 10:37
 */
@Data
@Component
@Slf4j
public class GenericFallbackProvider implements FallbackProvider {


    //api服务id，如果需要所有调用都支持回退，则return "*"或return null
    @Override
    public String getRoute() {
        return null;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        //打印引起回退的原因
        log.warn("网关降级，原因：{}, 路由信息：{}", cause, route);

       /* boolean flag = cache.setnx("gateway", CacheModule.DEFAULT.getModule(), "1", DateUtils.findMilliSecondsNowToToday());
        if (flag) {
            String msg = "商家网关发生了降级。 route=" + route;
            smsService.send(msg, Arrays.asList(MerchantConstants.ADMINISTRATOR_MOBILE), "admin", ProducerTarget.NORMAL);
        }*/
        return getCustomClientHttpResponse();
    }


    private ClientHttpResponse getCustomClientHttpResponse() {
        return new ClientHttpResponse() {

            @Override
            public InputStream getBody() throws IOException {
                ResponseBean baseResponse = new ResponseBean();
                baseResponse.setCode("MG2001");
                baseResponse.setDesc("系统处理不过来，请稍候再试");
                return new ByteArrayInputStream(JSON.toJSONBytes(baseResponse));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }

            @Override
            public void close() {

            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            /**
             * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
             * 不应该把api的404,500等问题抛给客户端
             * 网关和api服务集群对于客户端来说是黑盒子
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

        };
    }
}
