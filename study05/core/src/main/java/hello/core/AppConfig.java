package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

	//	public MemberService memberService() {
	//		return new MemberServiceImpl(new MemoryMemberRepository());
	//	}
	//	public OrderService orderservice(){
	//		return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
	//	}


	//역할과 구현 구분이 확실!

	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository()); //ctrl + alt + M
	}

	private MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	public OrderService orderservice(){
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	public DiscountPolicy discountPolicy(){
		return new RateDiscountPolicy();
	}


}
