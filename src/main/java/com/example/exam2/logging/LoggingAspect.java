package com.example.exam2.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoggingAspect {

    @Before(value = "execution(* com.example.exam2.service.*.*(..)))")
    public void logBefore(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Enter into " + className + "." + methodName);
    }

    @After(value = "execution(* com.example.exam2.service.*.*(..)))")
    public void logAfter(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Exit from " + className + "." + methodName);
    }
}
