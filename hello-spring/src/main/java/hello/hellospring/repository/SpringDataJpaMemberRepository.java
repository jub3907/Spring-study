package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 인터페이스만 있더라도, JpaRepository를 받고있으면 구현체를 자동으로 만들어서, 자동으로 스프링 빈에 등록해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL select m from Member m where m.name = ?
    // findByxxx 메소드명을 사용해, 자동으로 위의 JPQL 쿼리를 생성한다.
    @Override
    Optional<Member> findByName(String name);
}
