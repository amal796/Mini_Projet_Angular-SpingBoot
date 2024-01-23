package com.example.premierprojettest.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class aspect {
    @Before("execution(* com.example.premierprojettest.Service.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + name + " : ");
    }

    @Before("execution(* com.example.premierprojettest.Service.*.retrieve*())")
    public void logMethodMessage(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Bonjour, In method " + name + " : ");
    }

    @After("execution(* com.example.premierprojettest.Service.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Out method " + name + " : ");
    }

    @Around("execution(* com.example.premierprojettest.Service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Method execution time: " + elapsedTime + " milliseconds.");
        return obj;
    }
}
