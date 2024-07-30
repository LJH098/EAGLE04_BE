package EAGLE04.demo.application.port.out.favorite;

import EAGLE04.demo.application.domain.FavoriteEntity;

import java.util.Optional;

public interface FavoritePort {
    Boolean existsByMemberId(Long memberId);
}
