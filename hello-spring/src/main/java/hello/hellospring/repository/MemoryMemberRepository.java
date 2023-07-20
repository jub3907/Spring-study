package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    // 실무일 때, 동시성 문제가 있을 수 있을땐 concurrent hashmap 사용해야 함.
    private static Map<Long, Member> store = new HashMap<>();
    // 키 값, 실무에선 동시성 문제로 인해 다른 방식으로 사용해야함.
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // null이 반환될 가능성이 있을 경우, Optional.ofnullable로 감쌈.
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        // 루프 실행
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        // 자바에서 실무할 땐, 리스트 자주 사용.
        return new ArrayList<>(store.values());
    }

    // 테스트가 종료될 때마다, 깔끔하게 메모리DB를 지워준다.
    public void clearStore() {
        store.clear();
    }

}
