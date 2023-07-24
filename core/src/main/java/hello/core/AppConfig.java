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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Application의 환경 구성을 Config에서 전담.
// @Configuration : 설정 정보
@Configuration
public class AppConfig {

    // @Bean -> 스프링 컨테이너에 등록됨.
    // Repository는 Memory로 할 것이다.
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // Discount Policy는 Fix를 사용한다.
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    // 멤버 서비스에선, MemberServiceImpl을 사용하겠다.
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 오더 서비스에선 OrderServiceImpl을 사용하겠다.
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}