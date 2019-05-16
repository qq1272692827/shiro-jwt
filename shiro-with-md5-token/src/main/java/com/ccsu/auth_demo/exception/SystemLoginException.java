package com.ccsu.auth_demo.exception;

import lombok.Data;

/**
 *业务逻辑异常
 * @author wenzhenyu
 * @date 2019/4/9
 * @param  * @param null
 * @return
 */
@Data
public class SystemLoginException extends RuntimeException {

    private int code;
    private String message;

    public SystemLoginException() {
        super();
    }
    public SystemLoginException(String message) {
        super(message);
    }

    public SystemLoginException(Throwable cause) {
        super(cause);
    }

    public SystemLoginException(int  code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public SystemLoginException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public SystemLoginException(int code , String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public SystemLoginException(int code , String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

}
