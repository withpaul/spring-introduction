package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    /**
     * 테스트 함수는 순서가 정해져 있지 않기 떄문에
     * 각 테스트 함수 끝나고 이 함수를 호출하게 하여 각 데이터를 비워줘야함
     */
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("KIM");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("KIM");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("AHN");
        repository.save(member2);

        Member result = repository.findByName("KIM").get();
        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("KIM");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("AHN");
        repository.save(member2);

        List<Member> members = repository.findAll();
        assertThat(members.size()).isEqualTo(2);
    }
}
