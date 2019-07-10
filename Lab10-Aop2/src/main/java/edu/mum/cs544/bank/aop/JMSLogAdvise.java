package edu.mum.cs544.bank.aop;

import edu.mum.cs544.bank.jms.IJMSSender;
import edu.mum.cs544.bank.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLogAdvise {
    @Autowired
    private ILogger logger;

    public JMSLogAdvise(ILogger logger){
        this.logger = logger;
    }

    @After("execution(* edu.mum.cs544.bank.jms.JMSSender.sendJMSMessage(..)) && args(message)")
    public void logAfter(JoinPoint joinPoint, String message){
        logger.log("Message = "+message);
    }
}
