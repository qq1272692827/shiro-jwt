package com.ccsu.auth_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wenzhenyu
 * @description
 * @date 2019/5/15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

}
