package hello.hellospring.controller;

public class MemberForm {
    // 해당 name 변수와, createMemberForm.html의 input 태그의 name이 매칭된다.
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
