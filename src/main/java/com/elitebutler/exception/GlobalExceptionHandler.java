package com.elitebutler.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;

/**
 * 异常处理器
 */
@Slf4j
@ControllerAdvice
//@RestControllerAdvice相当于@ControllerAdvice+@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 对自定义异常进行处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(EliteButlerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse customException(EliteButlerException e){
        // 记录异常日志
        log.error("系统异常: {}", e.getErrMessage());
        // 可以进行更加细致的处理

        // 解析出异常信息 响应给前端
        return new RestErrorResponse(e.getErrMessage());
    }

    /**
     * 对系统异常进行处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse Exception(Exception e){
        // 记录异常日志
        log.error("系统异常: {}", e.getMessage());
        // 解析出异常信息
        return new RestErrorResponse(CommonError.UNKOWN_ERROR.getErrMessage());
    }

    /**
     *  当使用 @Validated 注解进行方法参数验证时，如果验证失败，Spring会抛出 MethodArgumentNotValidException 异常,从而走系统异常处理
     *  而表单错误不是系统错误, 所以我们不希望表单验证失败时走系统错误, 所以设置了这个异常处理器
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)//该异常类通常在方法参数验证失败时抛出。这个异常是在使用 @Valid 注解进行方法参数验证时可能会发生的一种异常。
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorResponse methodArgException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();// 异常处理中的 bindingResult 包含了详细的验证错误信息，可以根据需要进行处理。
        // 存储错误信息
        ArrayList<String> errors = new ArrayList<>();
        bindingResult.getFieldErrors().stream().forEach(item -> errors.add(item.getDefaultMessage()));
        // 将错误信息拼接起来
        String errorMessage = StringUtils.join(errors, ",");
        // 记录异常日志
        log.error("系统异常: {}", errorMessage);
        // 解析出异常信息
        return new RestErrorResponse(errorMessage);
    }
}
