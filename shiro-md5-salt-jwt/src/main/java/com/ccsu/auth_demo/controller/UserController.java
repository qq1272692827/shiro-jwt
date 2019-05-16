package com.ccsu.auth_demo.controller;

import com.ccsu.auth_demo.dto.Message;
import com.ccsu.auth_demo.entity.User;
import com.ccsu.auth_demo.service.UserService;
import com.ccsu.auth_demo.vo.TestVo;
import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenzhenyu
 * @description
 * @date 2019/5/15
 */
@RestController
//@RequestMapping("")
public class UserController  {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserService userService;

    @RequiresPermissions("test:user:test")
    @RequestMapping("/v1/user/getUserInfo")
    public Message getUserInfo(String userId){

        User user = userService.getUserInfo(userId);
        return new Message(0,"success",user);
    }


    @RequiresPermissions("system:user:view")
    @RequestMapping("/v1/userDetail")
    public Message userDetail(String userId){

        User user = userService.getUserInfo(userId);
        return new Message(0,"success",user);
    }

    @RequestMapping("/save")
    public Message save(String value){
        TestVo testVo = new TestVo("admin","123456");
        redisTemplate.opsForValue().set("username",testVo);
        return new Message(0,"success",null);
    }

    @RequestMapping("/get")
    public Message get(String value){
        TestVo vo = (TestVo) redisTemplate.opsForValue().get("username");
        return new Message(0,"success",vo);
    }

}
