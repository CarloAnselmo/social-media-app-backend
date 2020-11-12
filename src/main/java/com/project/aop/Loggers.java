package com.project.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@Component
@Aspect
@CrossOrigin	// Doesn't actually seem to do anything
public class Loggers {
	
	final static Logger logger = Logger.getLogger(Loggers.class);
	
	@Before("execution(* validateUser(..))")
	public void beforeMethods(JoinPoint jp) {
		System.out.println(jp.getSignature());
		System.out.println("EGHBWEOGIWEBFOIUWEBNWEIUFNWEIUFNWEIUFN\nAOFUDYGEBFYWEBGFBWEF\nEFIUVEWGFWEBFYWEBFWEYFB");
		logger.info(jp.getSignature());
	}
	
	@Pointcut("execution(* com.project.controller.*.*(..))")
	public void beforeMethods2(JoinPoint jp) {
		System.out.println(jp.getSignature());
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		logger.info(jp.getSignature());
	}

}
