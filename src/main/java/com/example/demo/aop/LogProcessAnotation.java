package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * Date: 5/29/2023<br/>
 * Time: 1:44 PM<br/>
 */
@Aspect
public class LogProcessAnotation {

    @Pointcut("execution(* com.example.demo.service.ActivitiesStream.*(..))")
    // the pointcut signature
    private void anyActivitiStreamAlias() {}

    @AfterReturning("@annotation(com.example.demo.aop.ActivitiStreamAlias)")
    public void logAfterProcess(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        System.out.format("=== logAfterProcess %s @ %s ===", method.getDeclaringClass(), method.getName());

        ActivitiStreamAlias myAnnotation = method.getAnnotation(ActivitiStreamAlias.class);
        System.out.format("Action: %s", myAnnotation.action());
    }
}
