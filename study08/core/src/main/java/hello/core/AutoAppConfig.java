package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//컴포넌트 스캔을 하면 기본이 싱글톤을 보장
@ComponentScan(
	// basePackages = "hello.core.member", //member만 컴포넌트 스캔
	excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =
	Configuration.class)) //스프링 빈을 쫙 읽어서 등록해야한다. @컴포넌트 어모테이션을 찾아서 빈에 등록해준다.
//Configuration은 제외하고 스캔한다. Configuration도 component를 스캔하기 때문에 같이 하면 충돌
// 실무에서는 configuration을 제외하지않는다. 테스트를 위해

//컴포넌트스캔은 @Component들을 다 읽어 들인다.
public class AutoAppConfig { //basePackages를 설정하지 않으면 현재 패키지 아래 있는 것은 다 스캔

}
