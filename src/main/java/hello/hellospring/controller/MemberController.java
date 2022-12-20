package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/create")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/member/store")
    public String create(MemberCreateForm memberCreateForm) {
        Member member = new Member();
        member.setName(memberCreateForm.getName());
        memberService.join(member);
        return "redirect:/";
    }
}
