package com.personal.exception;

import com.personal.common.result.ResultCode;
import lombok.Data;

/**
 * @author year
 * @version v1.0
 * @program personal
 * @description 业务异常
 * @date 2020-06-28 18:24
 */

@Data
public class BusinessException extends RuntimeException {

    /*** 状态码*/
    private Integer code;

    /*** 提示消息*/
    private String message;

    /*** 消息枚举类*/
    private ResultCode resultCode;

    private BusinessException() {
    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
