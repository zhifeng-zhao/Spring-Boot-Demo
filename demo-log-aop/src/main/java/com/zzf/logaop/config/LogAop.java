package com.zzf.logaop.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zzf
 * @date 2021/3/7 11:27 下午
 */

@Slf4j
@Aspect
@Component
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Around("@annotation(demoLog)")
    public Object around(JoinPoint point,DemoLog demoLog) throws Throwable {

        log.info("请求参数:" + point.getArgs());
        log.info("请求方法:" + point.getSignature().getName());
        String agent = request.getHeader("User-Agent");
        log.info("请求浏览器:" + agent);
        log.info("请求方法名：" + demoLog.value());
        ProceedingJoinPoint joinPoint = (ProceedingJoinPoint) point;
        Object result = joinPoint.proceed();
        log.info("处理结果为:" + result);
        return result;
    }
}
