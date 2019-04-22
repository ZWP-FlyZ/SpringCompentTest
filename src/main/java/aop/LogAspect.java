package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	
	@Pointcut("execution(* TypeA.work*())")
	public void inTypeA() {}
	
	@Pointcut("execution(* TypeB.work*())")
	public void inTypeB() {}
	
	
	@Around("  inTypeB() || inTypeA() ")
	public Object doLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		System.err.println("before "+methodName);
		Object ret = pjp.proceed();
		System.err.println("after "+methodName);
		return ret;
	}
	
	
}
