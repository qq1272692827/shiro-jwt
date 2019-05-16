package com.ccsu.auth_demo.vo;

import com.ccsu.auth_demo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author wenzhenyu
 * @description
 * @date 2019/5/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo extends User {



    //令牌
    private String token;

    /**
     * 权限列表
     */
    private Set<String> permissions;

}
