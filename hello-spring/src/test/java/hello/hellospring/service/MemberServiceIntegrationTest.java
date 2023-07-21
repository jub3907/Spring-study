package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
// 데이터베이스는 Trasaction이라는 개념이 있음.
// DB에 Insert query까지 해준 뒤, 데이터를 commit해줘야 반영되는데 스프링에는 Transactional이라는 Annotation을 사용해
// DB에 Query를 삽입한 뒤, 테스트 후 롤백시켜 준다.
@Transactional
class MemberServiceIntegrationTest {

    // 스프링에게, Member service, repository를 달라는 요청.
    // 테스트 케이스이기 때문에, 굳이 생성자가 아닌 편한 Field Injection 사용
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    // 이제, 메모리를 초기화 시켜주는 clearStore가 필요치 않음.

    // 데이터베이스는 Trasaction이라는 개념이 있음.
    // DB에 Insert query까지 해준 뒤, 데이터를 commit해줘야 반영되는데 스프링에는 Transactional이라는 Annotation을 사용해
    // DB에 Query를 삽입한 뒤, 테스트 후 롤백시켜 준다.
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long savedId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(savedId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");
        //when
        memberService.join(member1);
        // member2를 join할건데, IllegalStateException이 터져야만 한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */

        //then

    }
/*

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
 */
}