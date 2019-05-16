package com.ccsu.auth_demo.shiro;

import com.ccsu.auth_demo.service.UserService;
import com.ccsu.auth_demo.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wenzhenyu
 * @description
 * @date 2019/4/28
 */

public class UserRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Session session = SecurityUtils.getSubject().getSession();
        //查询用户的权限
        UserVo userVO = (UserVo) session.getAttribute("user");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(userVO.getPermissions());
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) {
        log.info("是否每次都会执行到这里：");
        String loginName = (String) authcToken.getPrincipal();


        // 获取用户密码
        String password = new String((char[]) authcToken.getCredentials());
        UserVo userVO = userService.getUser(loginName, password);
        if (userVO == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }
        String realmName = getName();
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(userVO.getUserName());
        //封装用户信息，构建AuthenticationInfo对象并返回
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userVO.getUserName(), userVO.getPassword(),
                credentialsSalt, realmName);
        userVO.setPassword("");
        //将用户信息放入session中
        SecurityUtils.getSubject().getSession().setAttribute("user", userVO);
        return authcInfo;
    }

    public static void main(String[] args) {
        String hashAlgorithName = "MD5";
        String password = "123456";
        int hashIterations = 1024;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes("admin");
        Object obj = new SimpleHash(hashAlgorithName, password, credentialsSalt, hashIterations);
        System.out.println(obj);
        System.out.println(obj.toString());
    }


}
