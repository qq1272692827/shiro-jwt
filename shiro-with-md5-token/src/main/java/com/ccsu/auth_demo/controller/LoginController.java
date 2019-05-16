package com.ccsu.auth_demo.controller;

import com.ccsu.auth_demo.dto.Message;
import com.ccsu.auth_demo.exception.SystemLoginException;
import com.ccsu.auth_demo.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


/**
 * @author wenzhenyu
 * @description 登录
 * @date 2019/5/15
 */
@RestController
public class LoginController  {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public Message login(String username, String password){
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);//会触发com.itclj.common.shiro.UserRealm的doGetAuthenticationInfo方法
            Session session = SecurityUtils.getSubject().getSession();
            UserVo userVO = (UserVo) session.getAttribute("user");
            userVO.setToken((String) session.getId());
            return new Message(0,"",userVO);
        } catch (AuthenticationException e) {
            logger.error("登录遇到问题",e);
            return new Message(-1,"用户名或者密码错误","用户名或者密码错误");

        }

    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("msg","安全退出！");
        System.out.println("退出！！！");
        return "退出登录";
    }



}
