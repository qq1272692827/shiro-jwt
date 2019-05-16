package com.ccsu.auth_demo.mapper;

import com.ccsu.auth_demo.entity.Menu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * MenuMapper继承基类
 */
@Qualifier("sqlSessionFactory")
public interface MenuMapper{
    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    public Set<String> queryPermissionByUserId(String userId);

}