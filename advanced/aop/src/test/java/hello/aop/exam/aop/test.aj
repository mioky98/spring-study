package hello.aop.exam.aop;

import org.aopalliance.intercept.Joinpoint;

public aspect test {
	pointcut logCall(): execution(* hello(..));

	before(Joinpoint joinpoint): logCall(){
		System.out.println("before");
	}
	after(Joinpoint joinpoint): logCall(){
		System.out.println("after");
	}
}
