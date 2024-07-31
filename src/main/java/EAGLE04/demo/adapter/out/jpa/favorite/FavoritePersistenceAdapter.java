package EAGLE04.demo.adapter.out.jpa.favorite;

import EAGLE04.demo.application.domain.FavoriteEntity;
import EAGLE04.demo.application.port.out.favorite.FavoritePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FavoritePersistenceAdapter implements FavoritePort {
    private final FavoriteRepository favoriteRepository;
    @Override
    public Boolean existsByMemberId(Long memberId) {
        return favoriteRepository.existsByMemberEntity_Id(memberId);
    }

    @Override
    public FavoriteEntity command(FavoriteEntity favoriteEntity) {
        return favoriteRepository.save(favoriteEntity);
    }
}
