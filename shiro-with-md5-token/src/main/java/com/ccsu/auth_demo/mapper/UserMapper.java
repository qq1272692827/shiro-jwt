package com.ccsu.auth_demo.mapper;

import com.ccsu.auth_demo.entity.User;
import com.ccsu.auth_demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * UserMapper继承基类
 */
@Qualifier("sqlSessionFactory")
public interface UserMapper{

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    public UserVo queryUserByUserName(String userName);

}