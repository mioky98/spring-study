package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectV2 {

	@Pointcut("execution(* hello.aop.order..*(..))")
	private void allOrder(){} //pointcut signature

	@Around("allOrder()") //여기가 포인트 컷 -> 이 하위에 있는 파일 모두 AOP가 적용이 됨
	public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{ //doLog가 Advice
		log.info("[log] {}", joinPoint.getSignature()); //join point 시그니처, 메서드 호출됐는지,
		return joinPoint.proceed();
	}

}
