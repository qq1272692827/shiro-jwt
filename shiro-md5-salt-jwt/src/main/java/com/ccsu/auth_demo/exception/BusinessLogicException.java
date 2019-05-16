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
public class BusinessLogicException extends RuntimeException {

    private int code;
    private String message;

    public BusinessLogicException() {
        super();
    }
    public BusinessLogicException(String message) {
        super(message);
    }

    public BusinessLogicException(Throwable cause) {
        super(cause);
    }

    public BusinessLogicException(int  code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BusinessLogicException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public BusinessLogicException(int code , String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessLogicException(int code , String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

}
