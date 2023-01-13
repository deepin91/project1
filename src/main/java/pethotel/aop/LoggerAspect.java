package pethotel.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
	@Pointcut("execution(* pethotel..controller.*Controller.*(..)) || execution(* pethotel..service.*ServiceImpl.*(..)) || execution(* pethotel..mapper.*Mapper.*(..))")
	private void loggerTarget() {}

		
		@Around("loggerTarget()")
		public Object logPrinter(ProceedingJoinPoint joinPoint) throws Throwable {
			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			log.debug(className + "." + methodName + "()");
			return joinPoint.proceed();
		}
}
