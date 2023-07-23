package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
}
