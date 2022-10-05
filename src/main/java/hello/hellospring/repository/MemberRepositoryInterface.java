package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoryInterface {
    // 회원 저장
    Member save(Member member);

    // 아이디 조회
    Optional<Member> findById(Long id);

    // 이름 조회
    Optional<Member> findByName(String name);

    // 전체 조회
    List<Member> findAll();
}
