package com.oscar.nicholas.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* com.oscar.nicholas.api.LogTestApi.log(..))")
    public void log() {
    }

    @Before("log()")
//    @Before("execution(* com.oscar.nicholas.api.LogTestApi.log(..))")
    public void doBefore() {
        log.info("--------- doBefore 1---------");
    }

    @After("log()")
    public void doAfter() {
        log.info("--------- doAfter 2---------");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturning(Object result) {
        log.info("--------- doAfterReturning 3--------- result:{} ",result);
    }
}
