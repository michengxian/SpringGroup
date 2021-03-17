package com.mi.learn.springcloud.base.bean;

import lombok.Data;

@Data
public class RequestBean<T> implements BaseBean {

    private String seqNo;

    private String sourceSystem;

    private String version = "1.0";

    private T request;

}
