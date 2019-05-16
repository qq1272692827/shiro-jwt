package com.ccsu.auth_demo.handler;

import com.ccsu.auth_demo.dto.Message;
import com.ccsu.auth_demo.exception.BusinessLogicException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author wenzhenyu
 * @description 权限异常
 * @date 2019/4/29
 */
@RestControllerAdvice
public class BusinessLogicExceptionHandler {


    private static Log logger = LogFactory.getLog(BusinessLogicExceptionHandler.class);



    // 捕捉 CustomRealm 抛出的异常
    @ExceptionHandler(BusinessLogicException.class)
    public Message handleLoginUnauthorizedException(Exception ex) {
//        logger.error("查看错误日志",ex);
        return new Message(100,"还没有登录",null);
    }

}
