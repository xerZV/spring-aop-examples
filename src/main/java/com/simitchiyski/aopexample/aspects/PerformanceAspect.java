package com.simitchiyski.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class PerformanceAspect {

    Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Pointcut("@annotation(com.simitchiyski.aopexample.annotation.Performance)")
    public void annotatedWithPerformance() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    @Around("com.simitchiyski.aopexample.SystemArchitecture.Service() && annotatedWithPerformance()")
    public Object trace(ProceedingJoinPoint proceedingJP) throws Throwable {
        String methodInformation = proceedingJP.getStaticPart().getSignature().toString();
        StopWatch stopWatch = new StopWatch(methodInformation);
        stopWatch.start();
        try {
            return proceedingJP.proceed();
        } finally {
            stopWatch.stop();
            logger.info(stopWatch.prettyPrint());
        }
    }

}
