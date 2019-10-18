package com.simitchiyski.aopexample.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLoggingAspect {

    Logger logger = LoggerFactory.getLogger(ExceptionLoggingAspect.class);

    @AfterThrowing(pointcut = "com.simitchiyski.aopexample.SystemArchitecture.Repository() " +
            "|| com.simitchiyski.aopexample.SystemArchitecture.Service()", throwing = "ex")
    public void logException(Exception ex) {
        logger.error("Exception", ex);
    }

}
