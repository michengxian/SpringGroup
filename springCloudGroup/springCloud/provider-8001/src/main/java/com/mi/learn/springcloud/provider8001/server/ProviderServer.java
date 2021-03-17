package com.mi.learn.springcloud.provider8001.server;

import com.mi.learn.springcloud.bean.UserInfoBean;

public interface ProviderServer {

    UserInfoBean queryUserById(Long id);

    Boolean addUser(UserInfoBean bean);

}
