package com.simitchiyski.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TracingAspect {
    Logger log = LoggerFactory.getLogger(TracingAspect.class);

    //every method within every class annotated with @Service
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void springBeanPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    @Pointcut("@annotation(com.simitchiyski.aopexample.annotation.Trace)")
    public void annotatedWithTrace() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    @Pointcut("annotatedWithTrace() && beforeEveryServiceMethodExecutionPointCut()")
    public void annotatedWithTraceAndEveryServiceMethod() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    //Every public method in specific package in classes only contain "Service" with any params
    @Pointcut("execution(public !void com.simitchiyski.aopexample.*Service..*(..))")
    public void beforeEveryServiceMethodExecutionPointCut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

//    @Around("springBeanPointcut()")
//    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
////        if (log.isDebugEnabled()) {
////            log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
////                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
////        }
//        log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//        try {
//            Object result = joinPoint.proceed();
////            if (log.isDebugEnabled()) {
////                log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
////                        joinPoint.getSignature().getName(), result);
////            }
//
//            log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
//                    joinPoint.getSignature().getName(), result);
//            return result;
//        } catch (IllegalArgumentException e) {
//            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
//                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
//            throw e;
//        }
//    }

    @Around("annotatedWithTraceAndEveryServiceMethod()")
    public Object logAroundExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed();
            log.info("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), result);
            return result;
        } catch (Throwable throwable) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
            throw throwable;
        }
    }
}
