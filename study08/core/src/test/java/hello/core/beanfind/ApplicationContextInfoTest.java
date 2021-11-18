package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest { //Junit5부터는 public 생략해도 됨

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력하기")
	void findAllBean(){
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		// iter치고 tab누르면 for문 자동 완성됨
		for (String beanDefinitionName : beanDefinitionNames) {
			Object bean = ac.getBean(beanDefinitionName); //object가 꺼내진다
			//soutv치고 tab누르면 출력 api가 자동으로 나온다
			System.out.println("beanDefinitionName = " + beanDefinitionName + " object = " + bean);
		}
	}

	@Test
	@DisplayName("애플리케이션 빈 출력하기")
	void findApplicationBean(){
		String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		// iter치고 tab누르면 for문 자동 완성됨
		for (String beanDefinitionName : beanDefinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); //object가 꺼내진다

			//스프링 내부에서 사용하는 빈 : ROLE_INFRASTRUCTURE
			// 직접 등록한 애플리케이션 빈 : ROLE_APPLICATION

			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){ //내가 등록한 bean만 출력하고 싶을 때
				Object bean = ac.getBean(beanDefinitionName); //object가 꺼내진다
				System.out.println("beanDefinitionName = " + beanDefinitionName + " object = " + bean);
			}
		}
	}
}
