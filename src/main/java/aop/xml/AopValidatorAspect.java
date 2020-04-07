package aop.xml;

import org.aspectj.lang.JoinPoint;

public class AopValidatorAspect {

	public void beforeMethode(JoinPoint joinPoint) {
		String methodeName = joinPoint.getSignature().getName();
		System.out.println("--> validator of "+ methodeName);
	}
}
