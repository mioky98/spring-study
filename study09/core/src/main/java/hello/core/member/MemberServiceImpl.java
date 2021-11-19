package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //@bean 안해도 component만 넣어주면 됨!
public class MemberServiceImpl implements MemberService{

	private final MemberRepository memberRepository;

	@Autowired //자동 의존 관계 주입이 필요하다! 기존에는 AppConfig를 통해 주입 	//memberRepository를 만든 애를 bean에서 찾아서 외존관계를 주입해준다.
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public void join(Member member) {
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		return memberRepository.findById(memberId);
	}

	//테스트 용도
	public MemberRepository getMemberRepository(){
		return memberRepository;
	}
}
