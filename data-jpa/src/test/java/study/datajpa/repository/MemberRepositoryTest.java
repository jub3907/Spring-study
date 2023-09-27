package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
//@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void testMember() {
        Member member = new Member("username");
        Member savedMember = memberRepository.save(member);

        // 원랜, Optional이 NULL이면 NoSuchElementException이 터지므로, orElseThrow를 쓰던가 해야한다.
        Member findMember = memberRepository.findById(member.getId()).get();

        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void find() {
    }
}