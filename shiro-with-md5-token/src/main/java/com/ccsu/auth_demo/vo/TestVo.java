package com.ccsu.auth_demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wenzhenyu
 * @description
 * @date 2019/5/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestVo implements Serializable {

    private String username;
    private String password;

}
