package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    // Optional : NULL일 경우를 대비해, Optional 사용
    Optional<Member> findById(Long Id);
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
