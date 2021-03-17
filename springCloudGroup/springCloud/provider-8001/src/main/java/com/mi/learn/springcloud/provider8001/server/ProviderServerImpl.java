package com.mi.learn.springcloud.provider8001.server;

import com.mi.learn.springcloud.base.except.DefaultException;
import com.mi.learn.springcloud.bean.UserInfoBean;
import com.mi.learn.springcloud.domin.UserBean;
import com.mi.learn.springcloud.domin.UserRoleBean;
import com.mi.learn.springcloud.provider8001.mapper.ProviderMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServerImpl implements ProviderServer {

    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public UserInfoBean queryUserById(Long id) {
        return providerMapper.queryUserById(id);
    }

    @Override
    public Boolean addUser(UserInfoBean bean){
        if (StringUtils.isBlank(bean.getName())){
            throw new DefaultException("用户名不能为空");
        }
        if (StringUtils.isBlank(bean.getRoleName())){
            throw new DefaultException("用户角色不能为空");
        }
        UserRoleBean userRoleBeanReq = new UserRoleBean();
        userRoleBeanReq.setName(bean.getRoleName());
        UserRoleBean resUserRoleBean = providerMapper.queryUserRole(userRoleBeanReq);
        if (resUserRoleBean==null||StringUtils.isBlank(resUserRoleBean.getName())){
            throw new DefaultException("用户角色不存在");
        }
        UserBean userBeanReq = new UserBean();
        userBeanReq.setName(bean.getName());
        UserBean userBeanRes = providerMapper.queryUser(userBeanReq);
        if (userBeanRes!=null||StringUtils.isNotBlank(userBeanReq.getName())){
            throw new DefaultException("用户名已存在");
        }
        UserBean addUserBean = new UserBean();
        addUserBean.setName(bean.getName());
        addUserBean.setRoleId(resUserRoleBean.getId());
        providerMapper.addUser(addUserBean);
        return true;
    }
}
