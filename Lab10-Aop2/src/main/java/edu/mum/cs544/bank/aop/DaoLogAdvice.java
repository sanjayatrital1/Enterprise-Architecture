package edu.mum.cs544.bank.aop;

import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DaoLogAdvice {
    @Autowired
    private ILogger logger;

    public DaoLogAdvice(ILogger logger){
        this.logger = logger;
    }

    @After("execution(* edu.mum.cs544.bank.dao.*.*(..))")
    public void logAfter(JoinPoint joinPoint){
        logger.log("made call to "+joinPoint.getSignature().getName()+" on "+joinPoint.getTarget().getClass());
    }
}
