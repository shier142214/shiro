package com.zking.mapper;

import com.zking.model.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

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