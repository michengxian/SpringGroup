package com.mi.learn.springcloud.base.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ResponseUtils {

    public ResponseUtils() {
    }

    public static void handlerResponse(HttpServletResponse response, String code, String errorMessage) {
        String result = handlerErrorResultMessage(code, errorMessage);
        handlerResponse(response, result);
    }

    public static void handlerResponse(HttpServletResponse response, String result) {
        try {
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(result);
            writer.flush();
        } catch (Exception var3) {
            log.error("处理返回应答数据异常", var3);
        }

    }

    public static String handlerErrorResultMessage(String code, String errorMessage) {
        Map<String, Object> map = new HashMap();
        map.put("seqNo", System.currentTimeMillis());
        map.put("response", (Object)null);
        map.put("code", code);
        map.put("desc", errorMessage);
        return JSON.toJSONString(map);
    }

}
