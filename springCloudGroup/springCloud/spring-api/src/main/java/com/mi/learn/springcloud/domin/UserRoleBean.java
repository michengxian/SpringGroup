package com.mi.learn.springcloud.domin;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoleBean implements Serializable {

    private Long id;

    private String name;

}
