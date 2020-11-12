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
	
//	@Before("execution(* validateUser(..))")
//	public void beforeMethods(JoinPoint jp) {
//		for(int i = 0; i < 10; i++) {
//			System.out.println(jp.getSignature());
//		}
//		logger.info(jp.getSignature());
//	}
	
    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controller() {
    }
    
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void service() {
    }
    
    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    public void repository() {
    }

	
	@Before("controller()")
	public void controllerLogger(JoinPoint jp) {
		String[] parsed = jp.getSignature().toString().split("[.]+");
		String build = "("+parsed[parsed.length-3]+") "+parsed[parsed.length-2]+": "+parsed[parsed.length-1];
		System.out.println("------ Client has made a request ------");
		System.out.println(build);
		logger.info("------ Client has made a request ------");
		logger.info(build);
	}
	
	@Before("service() || repository()")
	public void elseLogger(JoinPoint jp) {
		String[] parsed = jp.getSignature().toString().split("[.]+");
		String build = "("+parsed[parsed.length-3]+") "+parsed[parsed.length-2]+": "+parsed[parsed.length-1];
		System.out.println(build);
		logger.info(build);
	}

}
