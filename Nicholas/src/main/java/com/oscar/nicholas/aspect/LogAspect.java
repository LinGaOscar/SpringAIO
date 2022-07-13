package com.oscar.nicholas.aspect;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.oscar.nicholas.api.*.*(..))")
    public void log() {
    }

    @Before("log()")
//    @Before("execution(* com.oscar.nicholas.api.LogTestApi.log(..))")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + '.' + joinPoint.getSignature().getName();
        RequestLog requestLog = new RequestLog(request.getRequestURI(), request.getRemoteAddr(), classMethod, joinPoint.getArgs());
        log.info(" Request ------- {}" , requestLog);
    }

    @After("log()")
    public void doAfter() {
//        log.info("--------- doAfter 2---------");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturning(Object result) {
        log.info(" result -------- {}", result);
    }

    @AllArgsConstructor
    @ToString
    private class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

    }
}
