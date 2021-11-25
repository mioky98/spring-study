package hello.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable { //target 정보가 invocation에 다   들어가 있음

		log.info("TimeProxy 실행");
		long startTime = System.currentTimeMillis();
		Object result = invocation.proceed(); //여기서 타겟을 알아서 찾아서 파라미터를 넘기면서 다 해줌!
		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("TimeProxy 종료 resultTime={}ms", resultTime);
		return result;

	}
}
