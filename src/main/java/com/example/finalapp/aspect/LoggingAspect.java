package com.example.finalapp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;
@Component
@Aspect
@Slf4j
public class LoggingAspect {
    @Pointcut("within(com.example.finalapp.service.DocumentService)")
    public void pointCut(){}

    @Pointcut("execution(public boolean createMessage())")
    public void pointCutMethod(){}

    @After("pointCut()")
    public void logInfoMethodCall(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        log.info("Method name " + methodName);
    }
}
