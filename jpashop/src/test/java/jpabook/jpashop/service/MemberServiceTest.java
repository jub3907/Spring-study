package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;

    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        memberRepository.save(member);

        // then
        assertThat(member).isEqualTo(memberRepository.findOne(member.getId()));
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when
        memberService.join(member1);

        // then
        assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class);

    }
}