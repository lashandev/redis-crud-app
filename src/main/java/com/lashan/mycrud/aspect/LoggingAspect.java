package com.lashan.mycrud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.lashan.mycrud.controller.DepartmentController.*(..)) " +
            "|| execution(* com.lashan.mycrud.controller.EmployeeController.*(..)) " +
            "|| execution(* com.lashan.mycrud.service.impl.EmployeeServiceImpl.*(..)) " +
            "|| execution(* com.lashan.mycrud.service.impl.DepartmentServiceEnableCache.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering method: " + joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            for (Object arg : args) {
                logger.info("Argument: " + arg);
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.lashan.mycrud.controller.DepartmentController.*(..)) " +
            "|| execution(* com.lashan.mycrud.controller.EmployeeController.*(..)) " +
            "|| execution(* com.lashan.mycrud.service.impl.EmployeeServiceImpl.*(..))" +
            "|| execution(* com.lashan.mycrud.service.impl.DepartmentServiceEnableCache.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Exiting method: " + joinPoint.getSignature().getName());
        if (result != null) {
            logger.info("Return value: " + result);
        }
    }
}
