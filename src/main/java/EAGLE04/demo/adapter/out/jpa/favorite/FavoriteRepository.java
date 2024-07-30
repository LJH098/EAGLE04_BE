package EAGLE04.demo.adapter.out.jpa.favorite;

import EAGLE04.demo.application.domain.FavoriteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Long> {
    Boolean existsByMemberEntity_Id(Long memberId);
    Optional<FavoriteEntity> findByMemberEntity_Id(Long memberId);
}
