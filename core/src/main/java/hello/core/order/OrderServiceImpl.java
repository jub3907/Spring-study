package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    // 구현체에 의존하지 않고, 추상화에만 의존하도록 변경.
    // 철저하게 DIP를 지키고 있음.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;



    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    // 주문 생성 요청이 존다면
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // repo에서 멤버를 찾고
        Member member = memberRepository.findById(memberId);
        // 할인 정책에 멤버를 넘겨서
        int discountPrice = discountPolicy.discount(member, itemPrice);

        // 생성된 주문을 반환한다.
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

