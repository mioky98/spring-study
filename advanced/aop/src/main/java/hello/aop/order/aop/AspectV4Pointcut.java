package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectV4Pointcut {

	@Around("hello.aop.order.aop.AspectV3.allOrder()")
	public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("[log] {}", joinPoint.getSignature());
		return joinPoint.proceed();
	}
	//hello.aop.order 패키지와 하위 패키지 이면서 클래스 이름 패턴이 *Service
	@Around("hello.aop.order.aop.Pointcuts.orderAndService()") //두가지 다 만족하는 파일은 Service뿐
	public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable
	{
		try {
			log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
			Object result = joinPoint.proceed();
			log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
			return result;
		} catch (Exception e) {
			log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
			throw e;
		} finally { //성공이 되든, 에러가나든 반드시 실행이된다.
			log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
		}
	}
}