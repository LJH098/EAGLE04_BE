package EAGLE04.demo.application.port.out.favorite;

import EAGLE04.demo.application.domain.FavoriteEntity;

public interface FavoritePort {
    Boolean existsByMemberId(Long memberId);
    FavoriteEntity command(FavoriteEntity favoriteEntity);
}
