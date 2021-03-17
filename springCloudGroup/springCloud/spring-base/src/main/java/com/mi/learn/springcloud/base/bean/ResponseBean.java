package com.mi.learn.springcloud.base.bean;

import lombok.Data;

@Data
public class ResponseBean<T> implements BaseBean {

    private String seqNo;

    private T response;

    private String code = "100";

    private String desc = "处理成功";

}
