package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("afreecatv");

        // when
        Long id = memberService.join(member);

        // then
        Assertions.assertThat(id).isEqualTo(member.getId());
    }

    @Test
    void validateDuplicateMember() {
        Member member1 = new Member();
        member1.setName("afreecatv");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("afreecatv2");
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        assertThat(illegalStateException.getMessage()).isEqualTo("이미 존재하는 회원입니다");

//        Assertions.assertThatThrownBy(()->memberService.join(member2), "예외가 발생하지 않았다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findMemberById() {
    }
}