package hello.aop.order.aop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AspectV6Advice {

	@Around("hello.aop.order.aop.Pointcuts.orderAndService()")
	public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable //ProceedingJoinPoint는 Around만 사용 가능
	{
		try {
			//@Before
			log.info("[around][트랜잭션 시작] {}", joinPoint.getSignature());
			Object result = joinPoint.proceed();
			//@AfterReturning
			log.info("[around][트랜잭션 커밋] {}", joinPoint.getSignature());
			return result;
		} catch (Exception e) {
			//@AfterThrowing
			log.info("[around][트랜잭션 롤백] {}", joinPoint.getSignature());
			throw e;
		} finally {
			//@After
			log.info("[around][리소스 릴리즈] {}", joinPoint.getSignature());
		}
	}

	@Before("hello.aop.order.aop.Pointcuts.orderAndService()")
	public void doBefore(JoinPoint joinPoint) { //joinPoint 시작전
		log.info("[before] {}", joinPoint.getSignature());
	}

	@AfterReturning(value = "hello.aop.order.aop.Pointcuts.orderAndService()", returning = "result") //return되는 값
	public void doReturn(JoinPoint joinPoint, Object result) { //result를 바꿀순x, Object로 받아야한다.
		log.info("[return] {} return={}", joinPoint.getSignature(), result);
	}

	@AfterThrowing(value = "hello.aop.order.aop.Pointcuts.orderAndService()", throwing = "ex") //여기선 자동으로 throw e;가 된다.
	public void doThrowing(JoinPoint joinPoint, Exception ex) {
		log.info("[ex] {} message={}", joinPoint.getSignature(), ex.getMessage());
	}

	@After(value = "hello.aop.order.aop.Pointcuts.orderAndService()")
	public void doAfter(JoinPoint joinPoint) {
		log.info("[after] {}", joinPoint.getSignature());
	}
}