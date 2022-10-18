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
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("member/create")
    public String create() {
        return "member/create";
    }
    // 컨트롤러
    @PostMapping("member/store")
    public String store(MemberCreateForm memberCreateForm) {
        Member member = new Member();
        member.setName(memberCreateForm.getName());
        this.memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("member/list")
    public String list(Model model) {
        List<Member> members = this.memberService.findMembers();
        model.addAttribute("members", members);
        return "member/list";
    }


}
