package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.*;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class AopValidatorAspect {
@Before("AopLoggingAspect.declarationJoinPointExpression()")
	public void beforeMethode(JoinPoint joinPoint) {
		String methodeName = joinPoint.getSignature().getName();
		System.out.println("--> validator of "+ methodeName);
	}
}
