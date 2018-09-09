package com.andreitop.newco.aspect;


import com.andreitop.newco.dto.TripDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);


    @Before("com.andreitop.newco.aspect.PointcutContainer.repositoryFind()")
    public void beforeRepoFind(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        logger.info(" ---> Method " + className + "." + methodName + " is about to be called");
    }

    @AfterReturning("com.andreitop.newco.aspect.PointcutContainer.repositoryDelete()")
    public void afterSuccessfulDeletion(JoinPoint joinPoint) {
        logger.info(" ---> Trip with id " + ((Long) joinPoint.getArgs()[0]) + " was deleted");
    }

    @After("com.andreitop.newco.aspect.PointcutContainer.repositorySave()")
    public void afterSave() {
        logger.info(" ---> New trip was saved");
    }


    @AfterReturning("com.andreitop.newco.aspect.PointcutContainer.repositoryUpdate()")
    public void afterSuccessfulUpdate(JoinPoint joinPoint) {
        logger.info(" ---> Trip with id " + ((TripDto) joinPoint.getArgs()[0]).getId() + " was updated");
    }

}
