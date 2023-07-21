package hello.hellospring.domain;

import javax.persistence.*;

// 엔티티 매핑. 이제, JPA가 관리하는 엔티티라는 의미가 된다.
@Entity
public class Member {

    // 유저 ID, 시스템이 지정
    // IDENTITY : DB가 ID를 자동으로 생성해주는 전략.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 유저 이름
    // @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
