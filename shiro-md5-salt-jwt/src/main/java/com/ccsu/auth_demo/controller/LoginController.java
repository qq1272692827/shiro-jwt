package com.ccsu.auth_demo.controller;

import com.ccsu.auth_demo.dto.Message;
import com.ccsu.auth_demo.exception.SystemLoginException;
import com.ccsu.auth_demo.mapper.UserMapper;
import com.ccsu.auth_demo.shiro.JWTUtil;
import com.ccsu.auth_demo.util.MD5SaltUtil;
import com.ccsu.auth_demo.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;


/**
 * @author wenzhenyu
 * @description 登录
 * @date 2019/5/15
 */
@RestController
public class LoginController  {

    @Autowired
    UserMapper userMapper;
    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public Message login(String username, String password){
        String realPassword = userMapper.getPassword(username);
        if( !MD5SaltUtil.getSaltverifyMD5( password,realPassword )){
            return new Message(1,"login fail", null);
        }
        return new Message(0,"", JWTUtil.createToken(username));
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg","安全退出！");
        System.out.println("退出！！！");
        return "退出登录";
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public Message unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return new Message(200,message,null);
    }

}
