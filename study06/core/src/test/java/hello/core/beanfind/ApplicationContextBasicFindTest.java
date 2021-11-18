package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*; //static
import static org.junit.jupiter.api.Assertions.*; //static

class ApplicationContextBasicFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName(){
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		//Assertions 생략하려면(static하게 설정하려면) alt+엔터누른 후 Add on-demand ~ 클릭
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("이름없이 타입으로만 조회")
	void findBeanByType(){
		MemberService memberService = ac.getBean(MemberService.class);
		//Assertions 생략하려면(static하게 설정하려면) alt+엔터누른 후 Add on-demand ~ 클릭
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("구체 타입으로 조회") // 구체 타입으로 조회하는 것은 선호x
	void findBeanByName2(){
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class); //객체를 반환하기 때문에 구체 타입으로 조회가능!
		//Assertions 생략하려면(static하게 설정하려면) alt+엔터누른 후 Add on-demand ~ 클릭
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
	}

	@Test
	@DisplayName("구체 타입으로 조회") // 구체 타입으로 조회하는 것은 선호x
	void findBeanByNameX(){
		//MemberService memberService = ac.getBean("xxxx", MemberService.class);
		assertThrows(NoSuchBeanDefinitionException.class,
			() -> ac.getBean("xxxx", MemberService.class)); //오른쪽에 있는 것을 실행하면 에러가나야한다는 구분
	}

}
