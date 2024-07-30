package EAGLE04.demo.application.port.in.favorite;

import EAGLE04.demo.adapter.in.favorite.response.CheckFavoriteResponse;

public interface CheckFavoriteUseCase {
    Boolean existsByMemberId (Long memberId);
}
