package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    // 한 개의 객체만 생성하면 되기 때문에, 스프링 컨테이너에 등록한 뒤 사용한다.
    private final MemberService memberService;

    // 한 개의 객체만 생성하면 되기 때문에, 스프링 컨테이너에 등록한 뒤 사용한다.
    // Autowired를 사용해 스프링 컨테이너에 있는 멤버 서비스를 가져다가 연결시켜 준다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
