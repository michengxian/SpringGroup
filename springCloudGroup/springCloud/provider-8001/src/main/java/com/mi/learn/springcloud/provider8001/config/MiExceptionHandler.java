package com.mi.learn.springcloud.provider8001.config;

import com.mi.learn.springcloud.base.config.ResponseUtils;
import com.mi.learn.springcloud.base.except.AbstractException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class MiExceptionHandler {


    @ExceptionHandler(value =Exception.class)
    public String handleException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        log.info("===================");

        String url = request.getRequestURL().toString();
        String method = request.getMethod();

        StringBuilder sb = new StringBuilder();
        sb.append(url).append("\n");
        sb.append(method).append("\n");

        if (ex instanceof AbstractException) {
            AbstractException e = (AbstractException) ex;

            log.info("营销通业务异常：{}", sb.toString());
            ResponseUtils.handlerResponse(response, "915", ex.getMessage());
        } else {
            log.error("营销通系统异常：{}", sb.toString(), ex);
            ResponseUtils.handlerResponse(response, "500", "系统出了点小问题，请稍后再试，谢谢");
        }

        return ex.getMessage();
    }

}
