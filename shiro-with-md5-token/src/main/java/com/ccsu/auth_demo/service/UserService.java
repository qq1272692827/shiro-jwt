package com.ccsu.auth_demo.service;

import com.ccsu.auth_demo.entity.User;
import com.ccsu.auth_demo.exception.BusinessLogicException;
import com.ccsu.auth_demo.vo.UserVo;

public interface UserService {

    public User getUserInfo(String userId);

    public UserVo getUser(String username,String password)throws BusinessLogicException;

}
