package aop.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;


public class AopLoggingAspect {


	public void beforeMethode(JoinPoint joinPoint) {
//		使用JointPoint 访问方法的签名和参数
		String methodeName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The methode <" + methodeName + "> begins with args: " + args);
	}
	/*
	 * 后置通知: 目标方法执行后(无论是否发生异常) 不能访问目标方法的返回值!!!
	 */

	
	public void afterMethode(JoinPoint joinPoint) {
		String methodeName = joinPoint.getSignature().getName();
		System.out.println("The methode <" + methodeName + "> ends.");
	}

//	返回通知
	
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodeName = joinPoint.getSignature().getName();
		System.out.println("The methode <" + methodeName + "> ends with " + result.toString());
	}
	/*
	 * 异常通知 出现异常使执行
	 */

	
	public void afterThrowing(JoinPoint joinPoint, NullPointerException ex) {
		String methodeName = joinPoint.getSignature().getName();
		System.out.println("The methode <" + methodeName + "> occurs: " + ex.toString());
	}


}
