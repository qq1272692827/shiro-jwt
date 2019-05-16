package com.ccsu.auth_demo.handler;

import com.ccsu.auth_demo.dto.Message;
import com.ccsu.auth_demo.exception.BusinessLogicException;

import com.ccsu.auth_demo.exception.SystemLoginException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wenzhenyu
 * @description 权限异常
 * @date 2019/4/29
 */
@RestControllerAdvice
public class AuthorizationExceptionHandler {


    private static Log logger = LogFactory.getLog(AuthorizationExceptionHandler.class);


    // 捕捉 UnauthenticatedException 抛出的异常
    @ExceptionHandler(UnauthenticatedException.class)
    public Message handleShiroException(Exception ex) {
       return new Message(200,"没有登录",null);
    }

    // 捕捉 UnauthorizedException 抛出的异常
    @ExceptionHandler(UnauthorizedException.class)
    public Message handleUnauthorizedException(Exception ex) {
        return new Message(100,"没有权限",null);
    }


    // 捕捉 UnauthorizedException 抛出的异常
    @ExceptionHandler(UnknownAccountException.class)
    public Message handleUnknownAccountException(Exception ex) {
        return new Message(500,"用户名或者密码错误",null);
    }


    // 捕捉 UnauthorizedException 抛出的异常
    @ExceptionHandler(SystemLoginException.class)
    public Message handleSystemLoginException(Exception ex) {
        return new Message(500,"用户名或密码错误",null);
    }

}
