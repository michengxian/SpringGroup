package com.mi.learn.springcloud.provider8001.mapper;

import com.mi.learn.springcloud.bean.UserInfoBean;
import com.mi.learn.springcloud.domin.UserBean;
import com.mi.learn.springcloud.domin.UserRoleBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProviderMapper {

    UserInfoBean queryUserById(Long id);

    UserBean queryUser(UserBean bean);

    void addUser(UserBean bean);

    UserRoleBean queryUserRole(UserRoleBean bean);

    void addUserRole(UserRoleBean bean);
}
