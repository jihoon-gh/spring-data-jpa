package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username")String username, @Param("age")int age);
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    @Query("select m.username from Member m")
    List<String> findUsernameList();

    List<Member> findListByUsername(String username);
    Member findMemberByUsername(String username);

    Optional<Member> findOptionalByUsername(String username);

    Slice<Member> findByage(int age, Pageable pageable);
}
