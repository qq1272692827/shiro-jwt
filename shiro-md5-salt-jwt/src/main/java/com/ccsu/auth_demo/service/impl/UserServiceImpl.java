package com.ccsu.auth_demo.service.impl;

import com.ccsu.auth_demo.entity.User;
import com.ccsu.auth_demo.exception.BusinessLogicException;
import com.ccsu.auth_demo.exception.SystemLoginException;
import com.ccsu.auth_demo.mapper.MenuMapper;
import com.ccsu.auth_demo.mapper.UserMapper;
import com.ccsu.auth_demo.service.UserService;
import com.ccsu.auth_demo.util.MD5Util;
import com.ccsu.auth_demo.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

import java.util.Set;

/**
 * @author wenzhenyu
 * @description
 * @date 2019/5/15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    MenuMapper menuMapper;

    public User getUserInfo(String userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    public UserVo getUser(String username, String password) throws  BusinessLogicException{
        UserVo userVo =  userMapper.queryUserByUserName(username);
        Set<String> menus = menuMapper.queryPermissionByUserId( String.valueOf(userVo.getUserId() ) );
        userVo.setPermissions(menus);
//        userVo.setToken(getToken(username));
        return userVo;
    }

    private String getToken(String username) {
        return DigestUtils.md5DigestAsHex((username + System.currentTimeMillis()).getBytes());
    }

}
