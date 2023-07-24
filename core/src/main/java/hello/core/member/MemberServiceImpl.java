package hello.core.member;

public class MemberServiceImpl implements MemberService {

    //! 실제 할당하는 부분이, 구현체에 의존하고 있다는 문제점이 존재한다. DIP 위반!
    private final MemberRepository memberRepository;

    // 생성자를 통해, MemberRepository라는 인터페이스에만 의존하게 된다.
    // 생성자 주입.
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
}
