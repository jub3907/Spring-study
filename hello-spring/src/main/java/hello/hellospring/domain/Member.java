package hello.hellospring.domain;

public class Member {

    // 유저 ID, 시스템이 지정
    private Long id;
    // 유저 이름
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
