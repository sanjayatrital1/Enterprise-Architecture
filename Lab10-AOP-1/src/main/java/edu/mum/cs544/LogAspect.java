package edu.mum.cs544;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LogAspect {
    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(..)) && args(email, message)")
    public void logAfter(JoinPoint joinPoint, String email, String message){
        System.out.println(new Date()+" Method = "+joinPoint.getSignature().getName()+" email address= "+
                email+" message= "+message);
        IEmailSender emailSender = (IEmailSender) joinPoint.getTarget();
        System.out.println("outgoing mail server= "+emailSender.getOutgoingMailServer());
    }


}
