package com.benyissa.aspects;

import com.benyissa.services.SecurityContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
@EnableAspectJAutoProxy
public class SecurityAspect {

    @Around(value = "@annotation(securedByAspect)", argNames =
            "proceedingJoinPoint,securedByAspect")
    public Object log(ProceedingJoinPoint proceedingJoinPoint, SecuredByAspect
            securedByAspect) throws Throwable {
        String[] roles = securedByAspect.roles();
        boolean authorized = false;
        for (String r : roles) {
            if (SecurityContext.hasRole(r)) authorized = true;
        }
        if (!authorized) {
            throw new RuntimeException("Not Authorized");
        } else {
            Object o = proceedingJoinPoint.proceed();
            return o;
        }
    }
}
