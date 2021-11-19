package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //스프링 컨테이너에 자동으로 등록을 해주는 어노테이션
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;

// 아래는 @RequiredArgsConstructor과 같은 코드

	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy){
		this.memberRepository = memberRepository;
		this.discountPolicy = rateDiscountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice){
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	//테스트 용도
	public MemberRepository getMemberRepository(){
		return memberRepository;
	}

}
