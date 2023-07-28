package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy DiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = DiscountPolicy;
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

