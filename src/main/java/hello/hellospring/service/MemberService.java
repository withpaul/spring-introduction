package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    public final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository =  memberRepository;
    }

    /**
     * 가입
     * @param member
     * @return
     */
    public Long join(Member member) {
        // 중복 이름 불가
        validateDuplicateMember(member);
        return memberRepository.save(member).getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).
                ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 특정 ID 회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
