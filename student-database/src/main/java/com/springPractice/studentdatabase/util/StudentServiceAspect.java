package com.springPractice.studentdatabase.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class StudentServiceAspect {
	
	private static Logger logger = Logger.getLogger(StudentServiceAspect.class);
	
	@Before("execution(* com.springPractice.studentdatabase.service.StudentServiceImpl.*(..))")
	public void studentServiceLogger(JoinPoint joinPoint) {
		String classCalled = joinPoint.getSignature().toShortString();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//		LocalTime now = LocalTime.now();
		logger.info("Logging From StudentServiceAspect" + classCalled);
	}

}
