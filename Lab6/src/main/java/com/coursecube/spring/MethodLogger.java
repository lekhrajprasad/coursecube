/*
package com.coursecube.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.invoke.MethodHandles;


@Configuration
@EnableAspectJAutoProxy
@Aspect
public class MethodLogger {
    private final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Around("applicationPackagePointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result=null;

        if(logger.isDebugEnabled()){
            logger.debug(
                    "Start...  #{}#{}({})",
                    point.getSignature().getDeclaringType().getName(),
                    MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
                    point.getArgs(),
                    result
            );
        }else {
            logger.info(
                    "Start... #{}#{}(..)",
                    point.getSignature().getDeclaringType().getName(),
                    MethodSignature.class.cast(point.getSignature()).getMethod().getName()
            );
        }
        long start = System.currentTimeMillis();
        try{
            result = point.proceed();
        }catch(Throwable th){
            logger.error("Exception cought during method execution #####", th);
            throw th;
        }finally {
            if(logger.isDebugEnabled()){
                logger.debug(
                        "End... #{}#{}({}) :Result:: {} in {}ms",
                        point.getSignature().getDeclaringType().getName(),
                        MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
                        point.getArgs(),
                        result,
                        System.currentTimeMillis() - start
                );
            }else {
                logger.info(
                        "End... #{}#{}(..) : in {}ms",
                        point.getSignature().getDeclaringType().getName(),
                        MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
                        System.currentTimeMillis() - start
                );
            }
        }
        return result;
    }

    */
/**
     * Pointcut that matches all Spring beans in the application's main packages.
     *//*

    @Pointcut("within(com.coursecube.spring.*)"*/
/*+
            " || within(com.coursecube.spring.MethodLogger.*)"*//*
)
    public void applicationPackagePointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

}*/
