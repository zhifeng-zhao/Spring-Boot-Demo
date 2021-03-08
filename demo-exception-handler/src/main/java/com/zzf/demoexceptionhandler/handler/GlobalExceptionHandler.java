package com.zzf.demoexceptionhandler.handler;

import com.zzf.demoexceptionhandler.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zzf
 * @date 2021/3/8 10:47 上午
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponse exception(Exception e) {
        log.error("异常信息" + e.toString());
        return ApiResponse.fail(e.getLocalizedMessage(),null);
    }
}
