package com.mi.learn.springcloud.domin;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBean implements Serializable {

    private Long id;

    private String name;

    private Long roleId;

}
