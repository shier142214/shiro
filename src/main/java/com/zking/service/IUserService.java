package com.zking.service;

import com.zking.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public interface IUserService {

    /**
     * 验证用户登录
     * @param userName
     * @return
     */
    User selectByName(String userName);

    /**
     * 查询用户角色
     * @param userName
     * @return
     */
    Set<String> getRole(String userName);

    /**
     * 查询用户权限
     * @param userName
     * @return
     */
    Set<String> getPermission(String userName);
}
