package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        // MemberForm의 name 변수에 post로 넘어온 name 변수가 들어간다.
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        // home 화면으로 redirect.
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
