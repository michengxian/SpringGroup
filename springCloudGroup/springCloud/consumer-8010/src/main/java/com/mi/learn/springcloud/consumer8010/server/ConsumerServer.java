package com.mi.learn.springcloud.consumer8010.server;

import com.mi.learn.springcloud.base.bean.RequestBean;
import com.mi.learn.springcloud.bean.UserInfoBean;

public interface ConsumerServer {

    UserInfoBean queryUserById(RequestBean<String> requestBean);

    Boolean addUser(RequestBean<UserInfoBean> requestBean);

    UserInfoBean queryUserById1(RequestBean<String> requestBean);

    Boolean addUser1(RequestBean<UserInfoBean> requestBean);
}
