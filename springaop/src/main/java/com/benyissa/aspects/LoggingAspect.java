package com.benyissa.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@EnableAspectJAutoProxy
public class LoggingAspect {
    @Around("@annotation(com.benyissa.aspects.Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        Date t1 = new Date();
        System.out.println("Logging Aspect ===> Before execution ");
        result = joinPoint.proceed();
        Date t2 = new Date();
        System.out.println("Logging Aspect ===> After execution");
        System.out.println("Execution Duration : " + (t2.getTime() - t1.getTime()));
        return result;
    }
}
