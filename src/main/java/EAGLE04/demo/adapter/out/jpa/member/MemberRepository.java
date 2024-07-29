package EAGLE04.demo.adapter.out.jpa.member;

import EAGLE04.demo.application.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository
        extends JpaRepository<MemberEntity, Long> {

    Boolean existsByEmail(String email);
    Optional<MemberEntity> findByEmail(String email);
    Optional<MemberEntity> findByProvider(String provider);
}
