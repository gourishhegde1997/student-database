package com.springPractice.studentdatabase.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class StudentServiceAspect {
	
	private static Logger logger = Logger.getLogger(StudentServiceAspect.class);
	
	@Before("execution(* com.springPractice.studentdatabase.service.StudentServiceImpl.*(..))")
	public void studentServiceLoggerBefore(JoinPoint joinPoint) {
		String classCalled = joinPoint.getSignature().toShortString();
		logger.info("Triggered : " + classCalled);
	}

	@After("execution(* com.springPractice.studentdatabase.service.StudentServiceImpl.*(..))")
	public void studentServiceLoggerAfter(JoinPoint joinPoint) {
		String classCalled = joinPoint.getSignature().toShortString();
		logger.info("Returned from : " + classCalled);
	}
}
