package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach(){
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("afreecatv");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("afreecatv");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("youtube");
        repository.save(member2);

        Member result = repository.findByName("afreecatv").get();
        Assertions.assertThat(member1).isEqualTo(result);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("afreecatv");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("youtube");
        repository.save(member2);

        List<Member> list = repository.findAll();
        Assertions.assertThat(2).isEqualTo(list.size());
    }
}
