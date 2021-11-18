package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication //component scan이 들어가있음!
public class MemberApp {

	public static void main(String[] args) {

//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // Appconfig에 있는 코드들을 Bean에! 컨테이너에 넣어서 관리시켜준다.
		//컨테이너를 통해 가져온다.
		MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 컨테이너에 등록된 bean을 이름을 통해 꺼낸다.

		Member member = new Member(1L, "memberA", Grade.VIP);
		memberService.join(member);

		Member findMember = memberService.findMember(1L);
		System.out.println("new member = " + member.getName());
		System.out.println("find member = " + findMember.getName());
	}
}
