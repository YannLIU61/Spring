package aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//申明切面 AspectJ 注解
@Order(2)
@Aspect
@Component
public class AopLoggingAspect {

	/*
	 * 申明一个切入点表达式, 避免重复写
	 * 使用@PointCut
	 * 直接引用方法名
	 */
	@Pointcut("execution(public int aop.Caculator.*(int, int))")
	public void declarationJoinPointExpression() {};
	/*
	 * 前置通知: 目标方法执行前
	 * 
	 */
	@Before("declarationJoinPointExpression()")
	public void beforeMethode(JoinPoint joinPoint) {
//		使用JointPoint 访问方法的签名和参数
		String methodeName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The methode <" + methodeName + "> begins with args: " + args);
	}
	/*
	 * 后置通知: 目标方法执行后(无论是否发生异常) 不能访问目标方法的返回值!!!
	 */

	@After("declarationJoinPointExpression()")
	public void afterMethode(JoinPoint joinPoint) {
		String methodeName = joinPoint.getSignature().getName();
		System.out.println("The methode <" + methodeName + "> ends.");
	}

//	返回通知
	@AfterReturning(value = "declarationJoinPointExpression()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodeName = joinPoint.getSignature().getName();
		System.out.println("The methode <" + methodeName + "> ends with " + result.toString());
	}
	/*
	 * 异常通知 出现异常使执行
	 */

	@AfterThrowing(value = "declarationJoinPointExpression()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, NullPointerException ex) {
		String methodeName = joinPoint.getSignature().getName();
		System.out.println("The methode <" + methodeName + "> occurs: " + ex.toString());
	}

//	/*
//	 * 环绕通知 需携带 ProceedingJoinPoint 参数 类似于动态代理全过程 必须有返回值
//	 */
//	@Around("execution(public int aop.Caculator.*(int, int))")
//	public Object aroundMethode(ProceedingJoinPoint pjp) {
//		Object result = null;
//		String methodeName = pjp.getSignature().getName();
//		List<Object> args = Arrays.asList(pjp.getArgs());
//
//		try {
////			前置通知
//			System.out.println("The methode <" + methodeName + "> begins with " + args);
//			result = pjp.proceed();
////			返回通知
//			System.out.println("The methode ends.");
//		} catch (Throwable e) {
//			System.out.println("The methode <" + methodeName + "> occurs "+ e);
//		}
//// 后置通知
//		System.out.println("The methode ends");
//		return result;
//	}
}
