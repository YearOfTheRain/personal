package com.personal.exception;

import com.personal.common.result.ResponseEntity;
import com.personal.common.result.ResultCode;
import com.personal.common.util.request.RequestContextHolderUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author year
 * @version v1.0
 * @description 全局异常处理
 * @date 2020-06-28 16:39
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 方法描述: 处理参数不合法
     *
     * @author year
     * @date 2019/9/18
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info("handleMethodArgumentNotValidException start, uri:【{}】, caused by: 【{}】",
                RequestContextHolderUtil.getHttpServletRequest().getRequestURI(), e);
        return ResponseEntity.failure(ResultCode.PARAM_IS_BLANK_OR_TYPE_BIND_ERROR);
    }

    /**
     * 方法描述: 处理参数不合法
     *
     * @author year
     * @date 2019/9/18
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ResponseEntity handleMethodBindException(BindException e) {
        log.info("handleMethodBindException start, uri:【{}】, caused by: 【{}】",
                RequestContextHolderUtil.getHttpServletRequest().getRequestURI(), e);
        return ResponseEntity.failure(ResultCode.PARAM_IS_BLANK_OR_TYPE_BIND_ERROR);
    }

    /**
     * 方法描述: 处理请求内容不支持
     *
     * @author year
     * @date 2019/9/18
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity handleMethodHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.info("handleMethodHttpMediaTypeNotSupportedException start, uri:【{}】, caused by: 【{}】",
                RequestContextHolderUtil.getHttpServletRequest().getRequestURI(), e);
        return ResponseEntity.failure(ResultCode.REQUEST_CONTENT_TYPE_NOT_SUPPORTED, e.getMessage());
    }

    /**
     * 方法描述: 处理请求方法不支持
     *
     * @author year
     * @date 2019/9/18
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity handleMethodHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.info("handleMethodHttpRequestMethodNotSupportedException start, uri:【{}】, caused by: 【{}】",
                RequestContextHolderUtil.getHttpServletRequest().getRequestURI(), e);
        return ResponseEntity.failure(ResultCode.REQUEST_METHOD_NOT_SUPPORTED, e.getMessage());
    }

    /**
     * 方法描述: 消息不可读异常
     *
     * @author year
     * @date 2019/9/20
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleMethodHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.info("handleMethodHttpMessageNotReadableException start, uri:【{}】, caused by: 【{}】",
                RequestContextHolderUtil.getHttpServletRequest().getRequestURI(), e);
        return ResponseEntity.failure(ResultCode.PARAM_IS_BLANK, e.getMessage());
    }

    /**
     * 方法描述:  业务异常提示
     *
     * @author year
     * @date 2020/6/28 
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity handleBusinessException(BusinessException e) {
        log.info("handleMethodHttpRequestMethodNotSupportedException start, uri:【{}】, caused by: 【{}】",
                RequestContextHolderUtil.getHttpServletRequest().getRequestURI(), e.getMessage());
        return ResponseEntity.failure(e.getResultCode());
    }

    /**
     * 方法描述: 服务器错误，需要查找问题
     *
     * @author year
     * @date 2019/9/18
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleMethodRuntimeException(RuntimeException e) {
        log.info("handleMethodRuntimeException start, uri:【{}】, caused by: 【{}】",
                RequestContextHolderUtil.getHttpServletRequest().getRequestURI(), e);
        //todo 给管理员发短信、微信或者 QQ 消息提示
        return ResponseEntity.failure(ResultCode.SERVER_ERROR);
    }

}
